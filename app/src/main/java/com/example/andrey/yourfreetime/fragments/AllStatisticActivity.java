package com.example.andrey.yourfreetime.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class AllStatisticActivity extends Fragment {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    String _choosentype;
    DataBase YourDataBase;
    List<String> names=new ArrayList<>();
    int[] images = new int[20];
    ListView lvSimple;

    public AllStatisticActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_all_statistic, container, false);
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
                    // int nameColid = c.getColumnIndex("id_icon");
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
            }}}

}
