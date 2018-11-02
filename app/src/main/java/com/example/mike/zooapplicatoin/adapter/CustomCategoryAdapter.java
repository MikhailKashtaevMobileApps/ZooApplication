package com.example.mike.zooapplicatoin.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mike.zooapplicatoin.AnimalActivity;
import com.example.mike.zooapplicatoin.CategoryActivity;
import com.example.mike.zooapplicatoin.R;
import com.example.mike.zooapplicatoin.model.AnimalCategory;

import java.util.ArrayList;
import java.util.List;

public class CustomCategoryAdapter extends ArrayAdapter<AnimalCategory> {

    List<AnimalCategory> categoryActivities;
    int resource;

    public CustomCategoryAdapter(Context context, int resource, List<AnimalCategory> objects) {
        super(context, resource, objects);
        categoryActivities = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from( parent.getContext() ).inflate( this.resource, parent, false );

        if ( getItem( position ) != null ){
            TextView tv = convertView.findViewById( R.id.tvliCategory );
            tv.setText( getItem( position ).getName() );


            final String category = getItem( position ).getName();
            Context context = parent.getContext();

            class customOnClickListener implements View.OnClickListener{
                private Context context;
                customOnClickListener( Context context ){this.context = context;}

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AnimalActivity.class);
                    intent.putExtra( "category", category );
                    context.startActivity( intent );
                }
            }
            convertView.setOnClickListener(new customOnClickListener( context ));
        }

        return convertView;
    }
}
