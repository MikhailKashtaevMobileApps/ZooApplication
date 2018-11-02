package com.example.mike.zooapplicatoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mike.zooapplicatoin.adapter.CustomAnimalsAdapter;
import com.example.mike.zooapplicatoin.model.Animal;
import com.example.mike.zooapplicatoin.model.AnimalCategory;
import com.example.mike.zooapplicatoin.model.AnimalCategoryDao;
import com.example.mike.zooapplicatoin.model.AnimalDao;
import com.example.mike.zooapplicatoin.model.DaoSession;
import com.example.mike.zooapplicatoin.utils.DBHelper;

import java.util.List;

public class AnimalActivity extends AppCompatActivity {

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        daoSession = DBHelper.initDao(getApplicationContext());

        // Getting type of animals
        String category = (String) getIntent().getExtras().get("category");

        // Retrieve this category
        AnimalCategoryDao animalCategoryDao = daoSession.getAnimalCategoryDao();
        AnimalCategory animalCategory = animalCategoryDao.queryBuilder().where(AnimalCategoryDao.Properties.Name.eq(category)).unique();

        // Retrieving all animals of this type
        AnimalDao animalDao = daoSession.getAnimalDao();
        List<Animal> animals = animalDao.loadAll();

        for (Animal animal : animals) {
            if ( animal.getAnimalCategory().getName() != category ){
                animals.remove(animal);
            }
        }

        Toast.makeText( this, "Total Animals retrieved="+animals.size(), Toast.LENGTH_LONG ).show();

        CustomAnimalsAdapter customAnimalsAdapter = new CustomAnimalsAdapter(getApplicationContext(), R.layout.list_item_animal, animals);
        RecyclerView rvAnimalsList = findViewById( R.id.rvAnimalsList );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        rvAnimalsList.setAdapter( customAnimalsAdapter );
        rvAnimalsList.setLayoutManager(layoutManager);

    }
}
