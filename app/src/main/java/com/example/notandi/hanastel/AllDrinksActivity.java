package com.example.notandi.hanastel;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Notandi on 22-Oct-15.
 */
public class AllDrinksActivity extends MainActivity {

    private ListView listView;
    ArrayList<CocktailRecipe> cocktails = new ArrayList<>();
    AllDrinksAdapter adapter;


    String[] cocktailName ={
            "Mojito",
            "Sex on the beach",
            "Vodka Sprite",
            "Jaager bomb",
            "Stemmari á dollunni",
            "Sveita sælan",
            "Meistarinn úr suðri",
            "Gleymér ey"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_drinks);
        for(String name : cocktailName){
            cocktails.add(new CocktailRecipe(name, "picture.jpg"));
        }

        listView = (ListView) findViewById(R.id.drinks);
        adapter = new AllDrinksAdapter(this, cocktails);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}