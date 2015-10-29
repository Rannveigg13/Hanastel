package com.example.notandi.hanastel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("mytag", "before");
        DatabaseHelper myDbHelper = new DatabaseHelper(this);

        try{
            myDbHelper.createDataBase();
            Log.d("mytag", "creating database");
        }
        catch (IOException ioe) {
            Log.d("mytag","exception creating database");
            throw new Error("Unable to create database");
        }

        try {
            Log.d("mytag", "opening database");
            myDbHelper.openDataBase();
            //myDbHelper.close();
            //myDbHelper.openDataBase();
        }
        catch (SQLiteException sqle) {
            Log.d("mytag", "exception opening database");
            throw sqle;
        }

        myDbHelper.getStuff();
        /*Cursor c = myDbHelper.showAllTables();
        if (c.moveToFirst())
        {
            do{
                Log.d("ITEMS/TABLES", c.getString(0));

            }while (c.moveToNext());
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstance){
        super.onSaveInstanceState(savedInstance);
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

    public void onAllDrinksClick(View view){
        Intent intent = new Intent(this, AllDrinksActivity.class);
        startActivity(intent);
    }

    public void onSearchClick(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void onMyBarClick(View view){
        Intent intent = new Intent(this, MyBarActivity.class);
        startActivity(intent);
    }

    public void onRandomClick(View view){
        Intent intent = new Intent(this, RandomActivity.class);
        startActivity(intent);
    }

}
