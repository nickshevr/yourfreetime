package com.example.andrey.yourfreetime.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.classes.Parameters;

public class CategoryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    public void clickhealth (View view)
    {
        Intent intent = new Intent(this,AddActivity.class);
        Parameters.setChoosen_category("health");
        startActivity(intent);
    }

    public void clickcommunicate (View view)
    {
        Intent intent = new Intent(this,AddActivity.class);
        Parameters.setChoosen_category("communicate");
        startActivity(intent);
    }

    public void clickrelax (View view)
    {
        Intent intent = new Intent(this,AddActivity.class);
        Parameters.setChoosen_category("relax");
        startActivity(intent);
    }

    public void clickproductivity (View view)
    {
        Intent intent = new Intent(this,AddActivity.class);
        Parameters.setChoosen_category("productivity");
        startActivity(intent);
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
