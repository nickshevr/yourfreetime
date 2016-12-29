package com.example.andrey.yourfreetime.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.andrey.yourfreetime.R;

public class CentralActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);
    }

    public void clickadd (View view)
    {
        Intent intent = new Intent(this,CategoryActivity.class);
        startActivity(intent);
    }

    public void clickadvice (View view)
    {
        Intent intent = new Intent(this,AdviceActivity.class);
        startActivity(intent);
    }

    public void clickstatistic (View view)
    {
        Intent intent = new Intent(this,StatisticActivity.class);
        startActivity(intent);
    }

   // public void clickrating (View view)
   // {
   //     Intent intent = new Intent(this,StatisticActivitynull.class);
   //     startActivity(intent);
  //  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_central, menu);
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
