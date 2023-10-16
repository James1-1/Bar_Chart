package com.firstapp.bar_chart;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BarEntry> barEntries; // Define ArrayList with BarEntry objects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarChart barChart = findViewById(R.id.barchart);
        getData();

        // Set labels for X-axis (bottom)
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisLabels())); // Custom labels
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f); // This prevents duplicate labels when zooming

        // Set labels for Y-axis (left)
        YAxis leftYAxis = barChart.getAxisLeft();
        leftYAxis.setAxisMinimum(0f); // Set the minimum value for the Y-axis
        leftYAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        BarDataSet barDataSet = new BarDataSet(barEntries, "James");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        // Set colors for bar data
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        // Set color of text
        barDataSet.setValueTextColor(Color.BLACK);

        // Set text size
        barDataSet.setValueTextSize(16f);

        // Enable chart description (you can customize it)
        barChart.getDescription().setEnabled(true);
    }

    private void getData() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f, 10f));
        barEntries.add(new BarEntry(1f, 20f));
        barEntries.add(new BarEntry(2f, 30f));
        barEntries.add(new BarEntry(3f, 40f));
        barEntries.add(new BarEntry(4f, 50f));
    }

    private String[] getXAxisLabels() {
        // Return your custom labels for the X-axis
        return new String[]{" Tabuan Dayak", "Mile 3 Underpass", "Rock Road", "Taman Desa Wira", "Padang Merdeka"};
    }
}