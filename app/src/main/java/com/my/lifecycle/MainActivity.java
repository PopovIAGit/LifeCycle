package com.my.lifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int NAME_REQUEST = 13;
    public static final String NAME = "NAME";
    private String newName = "Ivan";
    private TextView text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);

        Log.d("happy", "on create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("happy", "on start");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("happy", "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("happy", "on stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("happy", "on resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("happy", "on destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("happy", "on restart");
        text1.setText(newName);

    }

    public void startDetaile(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(NAME, newName);
        startActivityForResult(intent, NAME_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == NAME_REQUEST && data != null){

           String s = data.getStringExtra(NAME);
           newName = s;
            Toast.makeText(this, "Name: "+s, Toast.LENGTH_SHORT).show();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}