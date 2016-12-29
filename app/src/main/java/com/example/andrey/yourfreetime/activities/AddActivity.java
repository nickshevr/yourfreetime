package com.example.andrey.yourfreetime.activities;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.classes.DataBase;
import com.example.andrey.yourfreetime.classes.Parameters;

public class AddActivity extends Activity {
    final String LOG_TAG = "myLogs";
    EditText etName;
    DataBase YourDataBase;
    String _choosentype;
    String _choosencategory;
    int id_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName=(EditText)findViewById(R.id.editText);
        YourDataBase=new DataBase(this);
    }


    public void clickred1(View v)
    {
        String name= etName.getText().toString();
            _choosencategory = Parameters.getChoosen_category();
            _choosentype = Parameters.getChoosen_type();
            id_icon=R.drawable.red1;

        AddToBase(_choosentype, name, id_icon,_choosencategory);
    }

    public void clickred2(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.red2;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickred3(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.red3;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickred4(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.red4;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickred5(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.red5;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickblue1(View v)
    {
        String name= etName.getText().toString();
        _choosencategory = Parameters.getChoosen_category();
        _choosentype = Parameters.getChoosen_type();
        id_icon=R.drawable.blue1;
        AddToBase(_choosentype,name,id_icon,_choosencategory);
    }

    public void clickblue2(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.blue2;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickblue3(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.blue3;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickblue4(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.blue4;
        AddToBase(_choosentype,name,id_icon,_choosencategory);
    }

    public void clickblue5(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.blue5;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickyellow1(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.yellow1;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickyellow2(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.yellow2;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickyellow3(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.yellow3;
        AddToBase(_choosentype,name,id_icon,_choosencategory);
    }

    public void clickyellow4(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.yellow4;
        AddToBase(_choosentype,name,id_icon,_choosencategory);
    }

    public void clickyellow5(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.yellow5;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickpurple1(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.purple1;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickpurple2(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.purple2;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickpurple3(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.purple3;
        AddToBase(_choosentype,name,id_icon,_choosencategory);

    }

    public void clickpurple4(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.purple4;
        AddToBase(_choosentype,name,id_icon,_choosencategory);
}

    public void clickpurple5(View v)
    {
        String name= etName.getText().toString();
        _choosencategory= Parameters.getChoosen_category();
        _choosentype=Parameters.getChoosen_type();
        id_icon=R.drawable.purple5;
        AddToBase(_choosentype,name,id_icon,_choosencategory);
    }

    public void AddToBase(String choosentype, String name, int id_icon, String _choosencategory)
{
    ContentValues cv=new ContentValues();
    SQLiteDatabase db=YourDataBase.getWritableDatabase();

            String _name=name;
            int _id_icon=id_icon;
            String choosencategory=_choosencategory;
            long _durationofnow=0;
            long _durationofday=0;
            long _durationofweek=0;
            long _durationofmonth=0;
            long _durationofall=0;
            cv.put("name", _name);
            cv.put("category", _choosencategory);
            cv.put("id_icon", _id_icon);
            cv.put("timeofbegin",_durationofnow);
            cv.put("durationofday",_durationofday);
            cv.put("durationofweek", _durationofweek);
            cv.put("durationofmonth", _durationofmonth);
            cv.put("durationofall", _durationofall);

    switch(_choosentype)
    {
        case "student":
        {
            Log.d(LOG_TAG, "--- Insert in student: ---");
            // подготовим данные для вставки в виде пар: наименование столбца - значение

            // вставляем запись и получаем ее ID
            long rowID = db.insert("student", null, cv);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID);
            break;
        }
        case "worker":
        {
            Log.d(LOG_TAG, "--- Insert in worker: ---");
            // подготовим данные для вставки в виде пар: наименование столбца - значение

            // вставляем запись и получаем ее ID
            long rowID = db.insert("worker", null, cv);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID);
            break;
        }
        case "pensioner":
        {
            Log.d(LOG_TAG, "--- Insert in pensioner: ---");
            // подготовим данные для вставки в виде пар: наименование столбца - значение

            // вставляем запись и получаем ее ID
            long rowID = db.insert("pensioner", null, cv);
            Log.d(LOG_TAG, "row inserted, ID = " + rowID);
            break;
        }
    }


}
}
