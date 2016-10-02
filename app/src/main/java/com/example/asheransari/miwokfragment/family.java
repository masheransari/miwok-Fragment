package com.example.asheransari.miwokfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class family extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new family_fragement()).commit();

    }
}
