package com.example.notandi.hanastel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SigurdurMarAtlason on 29/10/15.
 */
public class AllDrinksAdapter extends ArrayAdapter<CocktailRecipe> {

    public AllDrinksAdapter(Context context, List<CocktailRecipe> objects)  {
        super(context, 0, objects);
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        CocktailRecipe cr = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.drink_layout, parent, false);
        }


        TextView nameView = (TextView) convertView.findViewById(R.id.row_drink);
        nameView.setText(cr.getName());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.row_image);
        imageView.setImageResource(R.drawable.cocktail);
        //recipes.get(position).getImgPath()

        return convertView;
    }
}

/*
public class RecordAdapter extends ArrayAdapter<Record> {

    private final Context context;
    private final List<Record> values;

    public RecordAdapter(Context context, List<Record> objects) {
        super(context, -1, objects);
        this.context = context;
        this.values = objects;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent,false);

        TextView nameView = (TextView) rowView.findViewById(R.id.row_name);
        nameView.setText( values.get(position).getName() );

        //TextView coolView = (TextView) rowView.findViewById(R.id.row_cool);
        //coolView.setText( values.get(position).getCool() ? "Cool" : "Uncool" );

        ImageView coolView = (ImageView) rowView.findViewById(R.id.row_cool);
        coolView.setImageResource(values.get(position).getCool() ?
                R.drawable.ic_thumb_up_black_24dp : R.drawable.ic_thumb_down_black_24dp);

        return rowView;
    }
}
*/