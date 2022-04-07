package com.my.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       Intent intent = getIntent();
       String s = intent.getStringExtra(MainActivity.NAME);
        editText = findViewById(R.id.edit1);

        editText.setText(s);

        Log.d("happy", "on create det");
    }

    @Override
    public void onBackPressed() {

       String s = editText.getText().toString();
        Intent intent = new Intent();

        intent.putExtra(MainActivity.NAME, s);
        setResult(RESULT_OK, intent);

        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("happy", "on start det");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("happy", "on pause det");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("happy", "on stop det");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("happy", "on resume det");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("happy", "on destroy det");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("happy", "on restart det");

    }

    public void findInfo(View view) {
        String s = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yandex.ru/?q="+s));
        PackageManager packageManager = getPackageManager();
        if(intent.resolveActivity(packageManager) != null)
        startActivity(intent);
        else Log.d("happy", "cant find info");
    }


}