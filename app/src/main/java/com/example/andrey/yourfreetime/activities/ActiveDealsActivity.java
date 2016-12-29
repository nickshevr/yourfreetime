package com.example.andrey.yourfreetime.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.classes.DataBase;
import com.example.andrey.yourfreetime.classes.Parameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActiveDealsActivity extends ActionBarActivity {

    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    String _choosencategory;
    String _choosentype;
    DataBase YourDataBase;
    List<String> names=new ArrayList<>();
    List<String> days=new ArrayList<>();
    List<String> weeks=new ArrayList<>();
    List<String> months=new ArrayList<>();
    List<String> all=new ArrayList<>();
    List<String> times = new ArrayList<>();
    List<String> images= new ArrayList<>();
    ListView lvSimple;
    final String LOG_TAG="Mylogs";
    boolean[]timenow= new boolean[100] ;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_deals);
        YourDataBase=new DataBase(this);
        ReadFromBase();
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                names.size());
        Map<String, Object> m;
        for (int i = 0; i < names.size(); i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, names.get(i));
            m.put(ATTRIBUTE_NAME_IMAGE, images.get(i));
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE};
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = {R.id.tvText, R.id.ivImg};

        // создаем адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item,
                from, to);

        // определяем список и присваиваем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);

        lvSimple.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Вы закончили выполнять дело: " + names.get((int) id),
                        Toast.LENGTH_SHORT).show();
                _choosentype= Parameters.getChoosen_type();
                enddeal(names.get((int)id), Long.parseLong(times.get((int)id)), id );
            }
        });
    }

    public void enddeal(String name, long timeofbegin,long id)
    {
        ContentValues cv=new ContentValues();
        SQLiteDatabase db=YourDataBase.getWritableDatabase();
        String _name=name;
            long _timeofbegin=timeofbegin;
            long delta=System.currentTimeMillis()-_timeofbegin;
            long day = Long.parseLong(days.get((int)id));
            day+=delta;
            long week = Long.parseLong(weeks.get((int)id));
            week+=delta;
            long month = Long.parseLong(months.get((int)id));
            month+=delta;
            long al = Long.parseLong(all.get((int)id));
            al+=delta;
            cv.put("timeofbegin",0);
            cv.put("durationofday",day);
            cv.put("durationofweek", week);
            cv.put("durationofmonth", month);
            cv.put("durationofall", al);
            db.update("student", cv, "name= ? ", new String[]{name});
            Log.d(LOG_TAG, "Время запуска " + _timeofbegin);

    }

 public void AddToBase(String choosentype, String name, int id_icon, long timeofbegin)
    {
        ContentValues cv=new ContentValues();
        SQLiteDatabase db=YourDataBase.getWritableDatabase();
        String _name=name;
        int _id_icon=id_icon;
        long _timeofbegin=timeofbegin;
        long  _choosencategory=0;
        long _durationofday=0;
        long _durationofweek=0;
        long _durationofmonth=0;
        long _durationofall=0;
        cv.put("name", _name);
        cv.put("category", _choosencategory);
        cv.put("id_icon",_id_icon);
        cv.put("timeofbegin",_timeofbegin);
        cv.put("durationofday",_durationofday);
        cv.put("durationofweek", _durationofweek);
        cv.put("durationofmonth", _durationofmonth);
        cv.put("durationofall", _durationofall);
        long rowID = db.insert("student", null, cv);
    }

    public void clickcategory1(View v) {
        Intent intent = new Intent(this,StatisticCategoryActivity.class);
        startActivity(intent);
   }
    
    public void canclick(View v) {
       Intent intent = new Intent(this,StatisticActivity.class);
        startActivity(intent);
    }
    public void ReadFromBase()
    {
        SQLiteDatabase db=YourDataBase.getReadableDatabase();
        _choosentype = Parameters.getChoosen_type();

        switch(_choosentype)
        {
            case "student": {
                Cursor c2 = db.query("student", null, null, null, null, null, null);
                if (c2.moveToFirst()) {
                    int i = 0;
                    int nameColid2 = c2.getColumnIndex("timeofbegin");
                    do {
                        long k = c2.getInt(nameColid2);
                        if (k != 0) {
                            times.add(Long.toString(k));
                            timenow[i] = true;
                        } else timenow[i] = false;
                        i++;
                    } while (c2.moveToNext());
                }
                Cursor c = db.query("student", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    int nameColIndex = c.getColumnIndex("name");
                    int j = 0;
                    do {
                        if (timenow[j] == true)
                            names.add(c.getString(nameColIndex));
                        j++;
                    } while (c.moveToNext());
                }
                Cursor c1 = db.query("student", null, null, null, null, null, null);
                if (c1.moveToFirst()) {
                    int i = 0;
                    int nameColid = c1.getColumnIndex("id_icon");
                    do {
                        if (timenow[i] == true)
                            images.add(String.valueOf(c1.getInt(nameColid)));
                            i++;

                    } while (c1.moveToNext());

                    Cursor c3 = db.query("student", null, null, null, null, null, null);
                    if (c3.moveToFirst()) {
                        i = 0;
                        int nameColid3 = c3.getColumnIndex("durationofday");
                        do {
                            if (timenow[i] == true)
                                days.add(c3.getString(nameColid3));
                            i++;
                        } while (c3.moveToNext());

                        Cursor c4 = db.query("student", null, null, null, null, null, null);
                        if (c4.moveToFirst()) {
                            i = 0;
                            int nameColid4 = c4.getColumnIndex("durationofweek");
                            do {
                                if (timenow[i] == true)
                                    weeks.add(c4.getString(nameColid4));
                                i++;
                            } while (c4.moveToNext());

                            Cursor c5 = db.query("student", null, null, null, null, null, null);
                            if (c5.moveToFirst()) {
                                i = 0;
                                int nameColid5 = c5.getColumnIndex("durationofmonth");
                                do {
                                    if (timenow[i] == true)
                                        months.add(c5.getString(nameColid5));
                                    i++;
                                } while (c5.moveToNext());

                                Cursor c6 = db.query("student", null, null, null, null, null, null);
                                if (c6.moveToFirst()) {
                                    i = 0;
                                    int nameColid6 = c6.getColumnIndex("durationofall");
                                    do {
                                        if (timenow[i] == true)
                                            all.add(c6.getString(nameColid6));
                                        i++;
                                    } while (c6.moveToNext());
                                }
                                c.close();
                                c1.close();
                                c2.close();
                                c3.close();
                                c4.close();
                                c5.close();
                                c6.close();
                                YourDataBase.close();
                                break;
                            }
                        }
                    }
                }
            }}}}