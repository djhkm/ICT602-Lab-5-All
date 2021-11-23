package com.example.ict602_lab5b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  Button dialbutton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dialbutton = (Button)findViewById(R.id.button);
  }

  public void callPhoneNumber(View view) {
    try {
      if(Build.VERSION.SDK_INT > 22) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
          //TODO: Consider calling
          ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 101);
          return;
        }

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "601156565696"));
        startActivity(callIntent);
      }
      else {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "601156565696"));
        startActivity(callIntent);
      }
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}