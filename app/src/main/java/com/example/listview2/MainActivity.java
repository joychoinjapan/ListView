package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myclick(View v){
        switch (v.getId()){
            case R.id.array_btn:
                startActivity(new Intent(this,ArrayActivity.class));
                break;
            case R.id.simple_btn:
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.base_btn:
                startActivity(new Intent(this, BaseActivity.class));
                break;
        }
    }
}