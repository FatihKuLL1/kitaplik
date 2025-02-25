package com.example.kitapliktakipcim;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class ProgressActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_progress);

    PieChart pieChart = findViewById(R.id.pieChart);

    // Example data
    int totalBooks = 20; // User's goal
    int readBooks = 5; // Books read so far

    List<PieEntry> entries = new ArrayList<>();
    entries.add(new PieEntry(readBooks, "Okunan Kitaplar"));
    entries.add(new PieEntry(totalBooks - readBooks, "Kalan Kitaplar"));

    PieDataSet dataSet = new PieDataSet(entries, "Okuma İlerlemesi");
    PieData pieData = new PieData(dataSet);

    pieChart.setData(pieData);
    pieChart.invalidate(); // Refresh chart
  }
}
