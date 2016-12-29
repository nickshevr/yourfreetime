package com.example.andrey.yourfreetime.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import static android.widget.AdapterView.*;

public class StatisticActivity extends Activity {

    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    String _choosencategory;
    String _choosentype;
    DataBase YourDataBase;
    List<String> names=new ArrayList<>();
    int[] images = new int[20];
    ListView lvSimple;
    final String LOG_TAG="Mylogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        YourDataBase=new DataBase(this);
        //int img = R.drawable.red1;
        ReadFromBase();
        // упаковываем данные в понятную для адаптера структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                names.size());
        Map<String, Object> m;
        for (int i = 0; i < names.size(); i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, names.get(i));
            m.put(ATTRIBUTE_NAME_IMAGE, images[i]);
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

        lvSimple.setOnItemClickListener( new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Вы начали выполнять дело: "+ names.get((int)id),
                     Toast.LENGTH_SHORT).show();
                     UpDate((int)id,names.get((int)id));
            }
        });
    }

    public void UpDate(int id_icon, String name)
    {
        ContentValues cv=new ContentValues();
        SQLiteDatabase db=YourDataBase.getWritableDatabase();
        long _timeofbegin=System.currentTimeMillis();
        cv.put("timeofbegin",_timeofbegin);
        db.update("student", cv, "name= ? ", new String[]{name});
    }

    public void AddToBase(String choosentype, String name, int id_icon, long timeofbegin)
    {
        ContentValues cv=new ContentValues();
        SQLiteDatabase db=YourDataBase.getWritableDatabase();
        String _name=name;
        int    _id_icon=id_icon;
        long   _timeofbegin=timeofbegin;
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

    public void clickactivedeals(View v) {
        Intent intent = new Intent(this,ActiveDealsActivity.class);
        startActivity(intent);
    }

    public void clickcategory2(View v) {
        Intent intent = new Intent(this,StatisticCategoryActivity.class);
        startActivity(intent);
    }
    public void ReadFromBase()
    {
        SQLiteDatabase db=YourDataBase.getReadableDatabase();
        _choosentype = Parameters.getChoosen_type();

        switch(_choosentype)
        {
            case "student":
            {
                Cursor c = db.query("student", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    int nameColIndex = c.getColumnIndex("name");
                    do {
                        names.add(c.getString(nameColIndex));
                    } while (c.moveToNext());
                }
                Cursor c1 = db.query("student", null, null, null, null, null, null);
                if (c1.moveToFirst()) {
                    int i=0;
                    int nameColid = c1.getColumnIndex("id_icon");
                    do {
                        images[i]=c1.getInt(nameColid);
                        i++;
                    } while (c1.moveToNext());
                }
                c.close();
                c1.close();
                YourDataBase.close();
                break;
            }}}}
