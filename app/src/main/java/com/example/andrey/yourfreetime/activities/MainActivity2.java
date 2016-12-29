package com.example.andrey.yourfreetime.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.graphics.Typeface;

import com.example.andrey.yourfreetime.R;


public class MainActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void clickstudent(View view)
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("page", 0);
        startActivity(intent);
    }

    public void clickworker(View view)
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("page", 1);
        startActivity(intent);
    }

    public void clickpensioner(View view)
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("page", 2);
        startActivity(intent);
    }

}
