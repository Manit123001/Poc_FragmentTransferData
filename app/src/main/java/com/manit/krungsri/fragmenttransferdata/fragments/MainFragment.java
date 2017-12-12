package com.manit.krungsri.fragmenttransferdata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.manit.krungsri.fragmenttransferdata.R;
import com.manit.krungsri.fragmenttransferdata.Utils.BusProvider;
import com.manit.krungsri.fragmenttransferdata.activity.MainActivity;
import com.manit.krungsri.fragmenttransferdata.model.Category;
import com.manit.krungsri.fragmenttransferdata.model.Student;

/**
 * Created by MCNEWZ on 08-Dec-17.
 */

public class MainFragment extends Fragment {

    MyFragmentListener listener;
    Button btnOk ,btnStudent;
    MainActivity activity;

    /**
     * TODO : Event Listener
     */
    public interface MyFragmentListener {
        void onAddClick();

        void onUpdate();

        void onShow(String data);
    }

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance(String text, int num) {
        /**
         *  TODO : Construction Arguments
         * **/
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putInt("num", num);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("main", "onAttachFragment init");
        try {
            listener = (MyFragmentListener) getActivity();
            activity = (MainActivity) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("implement MyFragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Log.d("main", "onCreate init");

        if (bundle != null) {
            //  Arguments (Activity >> Fragment
            String text = bundle.getString("text");
            int num = bundle.getInt("num");
            Log.d("main", text);
            Log.d("main", num + "");
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        btnOk = rootView.findViewById(R.id.btnOk);
        btnStudent = rootView.findViewById(R.id.btnStudent);
        ininInstance();
        return rootView;
    }

    private void ininInstance() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventListener();
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // directListener();

                Category category = new Category();
                category.setId("5652410018");
                category.setName("Hello Manit");
                category.setDate("8/12/2017");
                BusProvider.getInstance().post(category);

                Student student =new Student();
                student.setFirstName("manit");
                student.setLastName("cholpinyo");
                student.setAge("23");
                BusProvider.getInstance().post(student);


            }
        });
    }

    private void eventListener() {
        listener.onAddClick();
        listener.onUpdate();
        listener.onShow("Hi Maint");
    }

    private void directListener(){
        /**
         * TODO : Method Directly
         */
        // call direct
        Student student =new Student();
        student.setFirstName("manit");
        student.setLastName("cholpinyo");
        student.setAge("23");
        activity.doSomethingByFragment(student);
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }

    }




}
