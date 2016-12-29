package com.example.andrey.yourfreetime.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.classes.DataBase;
import com.example.andrey.yourfreetime.classes.Parameters;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdviceActivity extends ActionBarActivity implements OnChartValueSelectedListener {

    private PieChart mChart;
    private SeekBar mSeekBarX;
    private TextView tvX, tvY;
    DataBase YourDataBase;
    List<String> names=new ArrayList<>();
    List<Integer> timeofday=new ArrayList<>();
    List<String> categories = new ArrayList<>();

    List<Integer> healths = new ArrayList<>();
    List<Integer> timesproductivity = new ArrayList<>();
    List<Integer> timescom = new ArrayList<>();
    List<Integer> timesrelax = new ArrayList<>();
    List<Integer> cater = new ArrayList<>();
    String _choosentype;
    Integer timeofallcommunicate=0,timeofallproductivity=0,timeofallrelax=0,timeofallhealth=0;
    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_advice);
        YourDataBase=new DataBase(this);
        ReadFromBase();

        for (int i=0; i<timesrelax.size(); i++)
        timeofallrelax+=timesrelax.get(i);

        for (int i=0; i<timescom.size(); i++)
            timeofallcommunicate+=timescom.get(i);

        for (int i=0; i<timesproductivity.size(); i++)
            timeofallproductivity+=timesproductivity.get(i);

        for (int i=0; i<healths.size(); i++)
            timeofallhealth+=healths.get(i);



        cater.add(timeofallhealth);
        cater.add(timeofallcommunicate);
        cater.add(timeofallproductivity);
        cater.add(timeofallrelax);
        names.add("Здоровье");
        names.add("Общение");
                names.add("Деятельность");
                        names.add("Отдых");

        tvX = (TextView) findViewById(R.id.tvXMax);

        mChart = (PieChart) findViewById(R.id.chart1);
        mChart.setUsePercentValues(true);
        mChart.setDescription("");

        mChart.setDragDecelerationFrictionCoef(0.95f);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);

        mChart.setTransparentCircleColor(Color.WHITE);

        mChart.setHoleRadius(3f);
        mChart.setTransparentCircleRadius(15f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);

        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(this);

        setData(4);

        mChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);

        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
    }

    private void setData(int count) {

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            yVals1.add(new Entry(cater.get(i), i));
        }

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count; i++)
            xVals.add(names.get(i));

        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);


        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(Color.rgb(250,108,72));
        colors.add(Color.rgb(243,180,105));
        colors.add(Color.rgb(73,168,216));
        colors.add(Color.rgb(209,159,212));
        colors.add(Color.rgb(202,87,58));
        colors.add(Color.rgb(204,152,88));
        colors.add(Color.rgb(66,127,176));
        colors.add(Color.rgb(209,159,212));


        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.rgb(200,200,200));
        data.setValueTypeface(tf);
        mChart.setData(data);

        mChart.highlightValues(null);

        mChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }


    public void ReadFromBase() {
        SQLiteDatabase db = YourDataBase.getReadableDatabase();
        _choosentype = Parameters.getChoosen_type();
        Cursor c = db.query("student", null, null, null, null, null, null);
        if (c.moveToFirst()){
            do {
                int nameColIndex = c.getColumnIndex("category");
                categories.add(c.getString(nameColIndex));
            } while (c.moveToNext());
    }
        Cursor c1= db.query("student", null, null, null, null, null, null);

        if (c1.moveToFirst()) {
            int i=0;
            int nameColId = c1.getColumnIndex("durationofday");
                do {

                    if(i==categories.size()) {
                        c.close();
                        c1.close();
                        YourDataBase.close();
                        break;
                    }
                    switch (categories.get(i)) {

                        case "productivity": {
                            timesproductivity.add(c1.getInt(nameColId));
i++;
                            break;
                        }
                        case "relax": {
                            timesrelax.add(c1.getInt(nameColId));
i++;
                            break;
                        }
                        case "health": {
                            healths.add(c1.getInt(nameColId));
i++;
                            break;
                        }
                        case "communicate": {
                            timescom.add(c1.getInt(nameColId));
 i++;
                            break;
                        }   }

                } while (c1.moveToFirst());
        }
    }
}
