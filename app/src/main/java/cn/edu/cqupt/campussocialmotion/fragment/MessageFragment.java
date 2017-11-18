package cn.edu.cqupt.campussocialmotion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.adapter.GetCircleAdapter;
import cn.edu.cqupt.campussocialmotion.adapter.MsgRecyclerAdaper;
import cn.edu.cqupt.campussocialmotion.model.Contact;
import cn.edu.cqupt.campussocialmotion.model.GetCircle;
import cn.edu.cqupt.campussocialmotion.net.GetCircleRetrofit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    RecyclerView contactor;
    public List<Contact> mContacts = new ArrayList<>();
    private List<GetCircle.BodyBean> circleList;
    private String id;
    private String content;
    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }
   public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contactor = (RecyclerView) getView().findViewById(R.id.rlist2);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contactor.setLayoutManager(linearLayoutManager);
        for(int i =0; i<10;i++){
            Contact a = new Contact("诺亚","快来打球吧");
            mContacts.add(a);
            Contact b = new Contact("我爱冠益乳","准备去跑步了");
            mContacts.add(b);

        }
       GetCircleRetrofit.getsInstance().getCircleService()
               .getCircle()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<GetCircle>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(GetCircle getCircle) {
                       circleList = getCircle.getBody();
                       GetCircleAdapter adapter1 = new GetCircleAdapter(circleList);
                       Toast.makeText(getActivity(), getCircle.getBody().get(0).toString(), Toast.LENGTH_SHORT).show();

                       contactor.setAdapter(adapter1);
                   }

                   @Override
                   public void onError(Throwable e) {
                       Toast.makeText(getActivity(), "ohmygod...", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onComplete() {

                   }
               });
        MsgRecyclerAdaper adaper = new MsgRecyclerAdaper(mContacts);
        contactor.setAdapter(adaper);


    }

}
