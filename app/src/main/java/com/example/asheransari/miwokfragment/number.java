package com.example.asheransari.miwokfragment;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class number extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catagory);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new number_fragement()).commit();

//        getActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
