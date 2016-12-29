package com.example.andrey.yourfreetime.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.classes.DataBase;
import com.example.andrey.yourfreetime.classes.Parameters;
import com.example.andrey.yourfreetime.classes.YourTime;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivitynull extends ActionBarActivity {
    final String LOG_TAG = "myLogs";
    String _choosentype;
    DataBase YourDataBase;
    List<String> names=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        YourDataBase=new DataBase(this);
        setContentView(R.layout.activity_statistic);
        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        Log.d(LOG_TAG, "зашло");
        ReadFromBase();

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ReadFromBase()
    {
        SQLiteDatabase db=YourDataBase.getReadableDatabase();
        _choosentype = Parameters.getChoosen_type();
        Log.d(LOG_TAG, "не зашло");
        switch(_choosentype)
        {
            case "student":
            {
                Log.d(LOG_TAG, "25");
                Cursor c = db.query("student", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    int nameColIndex = c.getColumnIndex("name");
                    do {
                        names.add(c.getString(nameColIndex));
                        Log.d(LOG_TAG, "Элемент массива");
                    } while (c.moveToNext());
                }
                c.close();
                YourDataBase.close();
                break;
            }
            case "worker":
            {
                break;
            }
            case "pensioner":
            {
                break;
            }
        }
    }
}
