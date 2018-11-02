package com.example.mike.zooapplicatoin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.zooapplicatoin.R;
import com.example.mike.zooapplicatoin.model.Animal;
import com.example.mike.zooapplicatoin.utils.BitmapHelper;

import java.util.List;

public class CustomAnimalsAdapter extends RecyclerView.Adapter< CustomAnimalsAdapter.ViewHolder > {

    private int layout;
    private Context context;
    private List<Animal> animals;

    public CustomAnimalsAdapter(Context context, int layout, List<Animal> animals ){
        this.layout = layout;
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int listItem) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( listItem, viewGroup, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Animal animal = animals.get(i);

        viewHolder.iv.setImageBitmap(
                BitmapHelper.bytes2bmp( animal.getAnimalPhoto() )
        );
        viewHolder.tv.setText( animal.getAnimalName() );
    }

    @Override
    public int getItemViewType(int position) {
        return this.layout;
    }

    @Override
    public int getItemCount() {
        return this.animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById( R.id.ivliAnimal );
            tv = itemView.findViewById( R.id.tvliAnimal );

        }
    }


}
