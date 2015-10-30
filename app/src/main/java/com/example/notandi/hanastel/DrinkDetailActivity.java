package com.example.notandi.hanastel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by SigurdurMarAtlason on 30/10/15.
 */
public class DrinkDetailActivity extends AllDrinksActivity {

    CocktailRecipe cr;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);
        Intent i = getIntent();
        cr = (CocktailRecipe)i.getSerializableExtra("clickedCocktail");
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
