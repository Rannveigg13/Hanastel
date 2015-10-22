package com.example.notandi.hanastel;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Notandi on 22-Oct-15.
 */
public class SearchActivity extends MainActivity{

    ArrayList<String> ingredients = new ArrayList<String>();
    ArrayAdapter ingredientAdapter;
    TextView searchBox;

    String[] drinks = {"Sex on the beach", "Gin and Tonic", "White Russian",
                        "Some fokking drink"};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // setup
        searchBox = (TextView) findViewById(R.id.search_Box);

        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.search_Box);
        actv.setAdapter(new ArrayAdapter<String>(this, R.layout.autocomplete_list, drinks));

        ingredientAdapter = new ArrayAdapter<String>(this, R.layout.ingredient_list, ingredients);
        ListView ingr = (ListView) findViewById(R.id.ingredient_list);
        ingr.setAdapter(ingredientAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void chooseIngredient(View view){
        /*
        TextView item = (TextView) findViewById(R.id.autocomplete_ingredient);
        Log.d("clickInfo", item.getText().toString());
        */
        ingredients.add("Vodki");
        ingredients.add("Romm");
        Log.d("ingr", ingredients.toString());
        ingredientAdapter.notifyDataSetChanged();
        searchBox.setText("");
    }
}
