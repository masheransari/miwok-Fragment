package com.example.asheransari.miwokfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
//    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        CatagoryAdapter catagoryAdapter = new CatagoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(catagoryAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

//        t1 = (TextView)findViewById(R.id.number);
//        t2 = (TextView)findViewById(R.id.family);
//        t3 = (TextView)findViewById(R.id.color);
//        t4 = (TextView)findViewById(R.id.phrase);
//        t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,number.class);
//                startActivity(i);
//            }
//        });
//        t2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,family.class);
//                startActivity(i);
//            }
//        });
//        t3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,color.class);
//                startActivity(i);
//            }
//        });
//        t4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,phrase.class);
//                startActivity(i);
//            }
//        });


    }   }
