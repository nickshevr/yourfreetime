package com.example.andrey.yourfreetime.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.classes.DataBase;

public class MainActivity1 extends ActionBarActivity {
    DataBase YourDataBase;
    long indicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        YourDataBase=new DataBase(this);
       // AddToBase();
        //ReadFromDataBase();
        //if(indicator==0){
         //   AddToBase();
        //}
        Typeface myTypeface= Typeface.createFromAsset(getAssets(),"GothaProBol.otf");
        TextView myTextView= (TextView)findViewById(R.id.textView2);
        myTextView.setTypeface(myTypeface);
        TextView myTextView1= (TextView)findViewById(R.id.textView);
        myTextView1.setTypeface(myTypeface);
        TextView myTextView2= (TextView)findViewById(R.id.textView11);
        myTextView2.setTypeface(myTypeface);
        ImageView icon = (ImageView) findViewById(R.id.icon);
        ImageView icon1= (ImageView) findViewById(R.id.icon1);
        ImageView icon3= (ImageView) findViewById(R.id.icon3);
        ImageView clock=(ImageView)findViewById(R.id.clock);

        Animation LoadingApp = AnimationUtils.loadAnimation(this, R.anim.loading);
        Animation LoadingRotate = AnimationUtils.loadAnimation(this, R.anim.loadingrotate);

        icon.startAnimation(LoadingApp);
        icon1.startAnimation(LoadingApp);
        icon3.startAnimation(LoadingApp);
        clock.startAnimation(LoadingRotate);

    TextView tv = (TextView) findViewById(R.id.textView11);
    Animation flashing = AnimationUtils.loadAnimation(this, R.anim.flashing);
    tv.startAnimation(flashing);

    }

    public void Click1(View view)
    {
        Intent intent = new Intent(MainActivity1.this,MainActivity2.class);
        startActivity(intent);
    }

    public void AddToBase()
    {
        ContentValues cv=new ContentValues();
        SQLiteDatabase db=YourDataBase.getWritableDatabase();
        long nowtime=System.currentTimeMillis();
        cv.put("timeofirstinclude",nowtime);
        db.insert("staticdata", null, cv);
    }

    public void ReadFromDataBase()
    {
        SQLiteDatabase db=YourDataBase.getReadableDatabase();
        Cursor c = db.query("staticdata", null, null, null, null, null, null);
            int nameColIndex = c.getColumnIndex("timeoffirstinclude");
        if(c.getLong(nameColIndex)!=0)
            indicator=c.getLong(nameColIndex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
