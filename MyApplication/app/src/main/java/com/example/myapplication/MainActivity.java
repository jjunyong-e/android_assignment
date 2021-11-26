package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
  public void get_btn_click(View view) {
    Intent intent = new Intent(this, getLocation.class);
    startActivity(intent);
  }
  public void internet_btn_click(View view) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tripadvisor.co.kr/Attractions-g294197-Activities-Seoul.html"));
    startActivity(intent);
  }

  public void find_btn_click(View view) {
    Intent intent = new Intent(this, findPlace.class);
    startActivity(intent);
  }
}
