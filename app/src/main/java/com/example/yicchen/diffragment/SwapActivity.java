package com.example.yicchen.diffragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SwapActivity extends AppCompatActivity {
    private FragmentManager fm;
    private ContactFragment contact;
    private DetailFragment detail;
    boolean s=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        contact=ContactFragment.newInstance("a","b");
        detail=DetailFragment.newInstance("a","b");
        fm=getSupportFragmentManager();
        FragmentTransaction trans=fm.beginTransaction();
        trans.add(R.id.fragment_container, contact);
        trans.commit();

    }
    public void swap(View v){
        FragmentTransaction trans = fm.beginTransaction();

        if(s=true) {
            trans.replace(R.id.fragment_container, detail);
            trans.addToBackStack(null);
            s=false;
        }
        else{
            trans.replace(R.id.fragment_container, contact);
            trans.addToBackStack(null);
            s=true;
        }
        trans.commit();
    }
}
