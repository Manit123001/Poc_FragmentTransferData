package com.manit.krungsri.fragmenttransferdata.activity;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.manit.krungsri.fragmenttransferdata.R;
import com.manit.krungsri.fragmenttransferdata.Utils.BusProvider;
import com.manit.krungsri.fragmenttransferdata.fragments.MainFragment;
import com.manit.krungsri.fragmenttransferdata.model.Category;
import com.manit.krungsri.fragmenttransferdata.model.Student;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity implements MainFragment.MyFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MainFragment myFragment = MainFragment.newInstance("Hi send data from activity to fragment", 1111);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.contentContainer, myFragment);
            transaction.commit();
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }

    /**
     *  TODO: Event Bus
     * **/
    @Subscribe
    public void receiveCategory(Category data) {
        // Do something when any event on fragment was happened
        Log.d("main", "1222222222222222222222222"+data.getName());

    }

    @Subscribe
    public void receiveCategory(Student data) {
        // Do something when any event on fragment was happened
        Log.d("main", "1222222222222222222222222"+data.getFirstName());

    }





    @Override
    public void onAddClick() {
        // Do SomeThing Here
        Log.d("main", "onAddClick");
        Toast.makeText(this, "onAddClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpdate() {
        // Do some thing here
        Log.d("main", "onUpdate");
        Toast.makeText(this, "onUpdate", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onShow(String data) {
        // Do some thing here

        Log.d("main", data);
        Toast.makeText(this, "onShow" + data, Toast.LENGTH_SHORT).show();

    }

    public void doSomethingByFragment(Student student) {
        // Do something when any event on fragment was happened
        Toast.makeText(this, student.getFirstName() + " " + student.getLastName() + " " + student.getAge(), Toast.LENGTH_SHORT).show();
    }


}
