package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;


public class findPlace extends AppCompatActivity {
  CsvHelper csvHelper;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.find_location);

    String filePath = getFilesDir().toString();
    System.out.println(filePath);
    csvHelper = new CsvHelper(filePath);
  }

  public void button_clicked(View view) {
    EditText first_station = (EditText) findViewById(R.id.first_station);
    EditText second_station = (EditText) findViewById(R.id.second_station);
    EditText third_station = (EditText) findViewById(R.id.third_station);
    String first_station_name = first_station.getText().toString();
    String second_station_name = second_station.getText().toString();
    String third_station_name = third_station.getText().toString();
    Float latSum = 0f;
    Float lngSum = 0f;
    List<String[]> arr = csvHelper.readAllCsvData("station.csv");
    Log.d("jhdroid_test", "first : " + first_station_name);
    Log.d("jhdroid_test", "second : " + second_station_name);
    Log.d("jhdroid_test", "third : " + third_station_name);
//    Log.d("jhdroid_test", "data : " + arr);
    for (String[] data : arr) {


      if (data[0].equals(first_station_name)){
        latSum += Float.parseFloat(data[1]);
        lngSum += Float.parseFloat(data[2]);
        Log.d("latSum",String.valueOf(latSum));
        Log.d("lngSum",String.valueOf(lngSum));
      }
      else if (data[0].equals(second_station_name) ){
        latSum += Float.parseFloat(data[1]);
        lngSum += Float.parseFloat(data[2]);
        Log.d("latSum",String.valueOf(latSum));
        Log.d("lngSum",String.valueOf(lngSum));
      }
      else if (data[0].equals(third_station_name)){
        latSum += Float.parseFloat(data[1]);
        lngSum += Float.parseFloat(data[2]);
        Log.d("latSum",String.valueOf(latSum));
        Log.d("lngSum",String.valueOf(lngSum));
      }
    }
    Float latMean = latSum/3;
    Float lngMean = lngSum /3;
    String resultlat = latMean.toString();
    String resultlng = lngMean.toString();
    Log.d("latMean",String.valueOf(resultlat));
    Log.d("lngMean",String.valueOf(resultlng));
    Float diff = 10000f;
    String resultStation = "";
    for (String[] data : arr) {
        if (diff >= (Math.abs(Float.parseFloat(data[1]) - latMean) + Math.abs(
            Float.parseFloat(data[2]) - lngMean))) {
          resultStation = data[0];
          diff = (Math.abs(Float.parseFloat(data[1]) - latMean) + Math.abs(
              Float.parseFloat(data[2]) - lngMean));
        }
    }
    Log.d("station", resultStation);
    TextView resultText = findViewById(R.id.resultText);
    resultText.setText(resultStation);
  }
//
//
//    String result = dbHelper.getResult(first_station_name,second_station_name,third_station_name);
//    TextView resultText = (TextView) findViewById(R.id.resultText);
//    Toast.makeText(this, (CharSequence) resultText, Toast.LENGTH_LONG).show();
//    resultText.setText(result);
  }

