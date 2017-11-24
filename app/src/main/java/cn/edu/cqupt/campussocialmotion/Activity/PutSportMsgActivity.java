package cn.edu.cqupt.campussocialmotion.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.feezu.liuli.timeselector.TimeSelector;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.SportPostMsg;
import cn.edu.cqupt.campussocialmotion.net.PostSportMsgRetrofit;
import cn.edu.cqupt.campussocialmotion.util.DateStringToTimeStamp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

public class PutSportMsgActivity extends AppCompatActivity {

    @BindView(R.id.activity_name) public EditText name;
    @BindView(R.id.activity_intro) public EditText intro;
    @BindView(R.id.remarks) public EditText remarks;
    @BindView(R.id.location) public EditText location;
    @BindView(R.id.people_needs) public EditText needs;
    @BindView(R.id.choose_activity) public RadioButton chooseActivity;
    @BindView(R.id.choose_competition) public RadioButton chooseCompetition;
    @BindView(R.id.choose_radiogroup) public RadioGroup radioGroup;

    @BindView(R.id.upload_msg) public TextView uploadMsg;

    @BindView(R.id.start_time) public TextView startTime;
    @BindView(R.id.end_time) public  EditText endTime;
    @BindView(R.id.upload_photo) public ImageView uploadPhoto;
    @BindView(R.id.back_post_activity) public ImageView backActivity;

    public final static int REQUEST_IMAGE = 2;
//    String activityName = name.getText().toString();
//    int stuNum = Integer.valueOf(getIntent().getStringExtra("stuId"));
//    String activityIntro = intro.getText().toString();
//    String activityRemarks = remarks.getText().toString();
//    long initTimeMi = System.currentTimeMillis();
//    long startTimeMi = System.currentTimeMillis() + 6000000;
//    long endTimeMi = System.currentTimeMillis() + 12000000;
//    String activityLocation = location.getText().toString();
//    int needsPeople = Integer.parseInt(needs.getText().toString());
//    String isRace = "active";

    String activityName;
    String stuNum;
    String activityIntro;
    String activityRemarks;
    long initTimeMi;
    long startTimeMi;
    long endTimeMi;
    String activityLocation;
    int needsPeople;
    String isRace;
    //RequestBody isRace;

    File pic;
    //RequestBody requestBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_sport_msg);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ButterKnife.bind(this);
        startTime.setFocusable(false);
        startTime.setFocusableInTouchMode(false);
        endTime.setFocusable(false);
        endTime.setFocusableInTouchMode(false);

        backActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        uploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_PICK);
                //intent.setType("image/*");
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeSelector timeSelector = new TimeSelector(PutSportMsgActivity.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        startTime.setText(time);
                        startTimeMi = Long.valueOf(DateStringToTimeStamp.getTimeStamp(time));
                    }
                }, "2017-1-1 00:00", "2025-12-31 59:59");
                timeSelector.setIsLoop(true);
                timeSelector.setTitle("请选择活动开始时间");
                timeSelector.show();
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeSelector timeSelector = new TimeSelector(PutSportMsgActivity.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        endTime.setText(time);
                        endTimeMi = Long.valueOf(DateStringToTimeStamp.getTimeStamp(time));
                    }
                }, "2017-1-1 00:00", "2025-12-31 59:59");
                timeSelector.setIsLoop(true);
                timeSelector.setTitle("请选择活动结束时间");
                timeSelector.show();
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroupListener());
        uploadMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(PutSportMsgActivity.this);
                progressDialog.setMessage("活动信息上传中...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                activityName = name.getText().toString();
                stuNum = getIntent().getStringExtra("stuId");
                activityIntro = intro.getText().toString();
                activityRemarks = remarks.getText().toString();
                initTimeMi = System.currentTimeMillis();
                activityLocation = location.getText().toString();
                needsPeople = Integer.parseInt(needs.getText().toString());

                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), pic);
                //requestBody = RequestBody.create(MediaType.parse("image/*"), pic);
                 MultipartBody.Part photo = MultipartBody.Part.createFormData("image", pic.getName(), requestBody);

//                RequestBody activityName2 = RequestBody.create(MediaType.parse("multipart/form-data"), activityName);
//                RequestBody stuNum2 = RequestBody.create(MediaType.parse("multipart/form-data"), stuNum);
//                RequestBody activityIntro2 = RequestBody.create(MediaType.parse("multipart/form-data"), activityIntro);
//                RequestBody activityRemarks2 = RequestBody.create(MediaType.parse("multipart/form-data"), activityRemarks);
//                RequestBody initTimeMi2 = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(initTimeMi));
//                RequestBody startTimeMi2 = RequestBody.create(MediaType.parse("multipart/form-data"), activityLocation);
//                RequestBody endTimeMi2 = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(needsPeople));
//                RequestBody activityLocation2 = RequestBody.create(MediaType.parse("multipart/form-data"), activityLocation);
//                RequestBody needsPeople2 = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(needsPeople));
//                RequestBody isRace2 = RequestBody.create(MediaType.parse("multipart/form-data"), activityName);



//                @Part("activityName") String active, @Part("initiator") String stuNUm, @Part("content")String intro,
////                                             @Part("remarks")String remarks, @Part("initTime")long initTime, @Part("startTime")long startTime,
////                                             @Part("endTime")long endTime, @Part("location")String location, @Part("peopleNeeds")int needs,
////                                             @Part("activityOrRace")String activeOrRace, @Part MultipartBody.Part picture);
                Map<String, RequestBody> map = new HashMap<>();
                map.put("activityName", RequestBody.create(null, activityName));
                map.put("initiator", RequestBody.create(null, "2015210054"));
                map.put("content", RequestBody.create(null, activityIntro));
                map.put("remarks", RequestBody.create(null, activityRemarks));
                map.put("initTime", RequestBody.create(null, String.valueOf(initTimeMi)));
                map.put("startTime", RequestBody.create(null, String.valueOf(startTimeMi)));
                map.put("endTime", RequestBody.create(null, String.valueOf(endTimeMi)));
                map.put("location", RequestBody.create(null, activityLocation));
                map.put("peopleNeeds", RequestBody.create(null, String.valueOf(needsPeople)));
                map.put("activityOrRace", RequestBody.create(null, isRace));

                PostSportMsgRetrofit.getsInstance().postActivityService()
//                        .getPostSportMsg(activityName2, stuNum2, activityIntro2, activityRemarks2,
//                                initTimeMi2, startTimeMi2, endTimeMi2, activityLocation2, needsPeople2, isRace2, photo)
                        .getPostSportMsg(map, photo)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<SportPostMsg>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(SportPostMsg sportPostMsg) {
                                progressDialog.dismiss();
                                Toast.makeText(PutSportMsgActivity.this, sportPostMsg.getMessage(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(PutSportMsgActivity.this,"ERROR!!!", Toast.LENGTH_SHORT).show();
                                Log.d("ERROR", "ERROR");
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                finish();
                            }
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE) {
//            Log.i("qqliLog", "GalleryUri:    " + data.getData());
//        }
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == REQUEST_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }

    private void showImage(String imaePath){
        Toast.makeText(this, imaePath, Toast.LENGTH_LONG).show();
        pic = new File(imaePath);
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        uploadPhoto.setImageBitmap(bm);
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == chooseActivity.getId()){
                //isRace = RequestBody.create(MediaType.parse("multipart/form-data"), "activity");
                isRace = "activity";
            }else if (checkedId == chooseCompetition.getId()){
                //isRace = RequestBody.create(MediaType.parse("multipart/form-data"), "race");
                isRace = "race";
            }
        }
    }

}
