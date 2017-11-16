package cn.edu.cqupt.campussocialmotion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.campussocialmotion.R;
import cn.edu.cqupt.campussocialmotion.model.Contact;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    RecyclerView contactor;
    public List<Contact> mContacts = new ArrayList<>();
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
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        contactor.setLayoutManager(linearLayoutManager);
        //int[] msg = {R.drawable.yd, R.drawable.yd1, R.drawable.yd3,R.drawable.yd, R.drawable.yd1, R.drawable.yd3};
        for(int i =0; i<10;i++){
            Contact a = new Contact("诺亚","快来打球吧");
            mContacts.add(a);
            Contact b = new Contact("我爱冠益乳","准备去跑步了");
            mContacts.add(b);

        }

       // contactor.setAdapter(new MsgRecyclerAdaper(mContacts));


    }

}
