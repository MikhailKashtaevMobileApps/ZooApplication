package com.example.mike.zooapplicatoin;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mike.zooapplicatoin.model.Animal;
import com.example.mike.zooapplicatoin.model.AnimalCategory;
import com.example.mike.zooapplicatoin.model.AnimalCategoryDao;
import com.example.mike.zooapplicatoin.model.AnimalDao;
import com.example.mike.zooapplicatoin.model.DaoMaster;
import com.example.mike.zooapplicatoin.model.DaoSession;
import com.example.mike.zooapplicatoin.utils.BitmapHelper;
import com.example.mike.zooapplicatoin.utils.DBHelper;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = DBHelper.initDao(getApplicationContext());

        if ( initCategories() ){
            initAnimals();
        }

    }

    public boolean initCategories(){

        AnimalCategoryDao animalCategoryDao = daoSession.getAnimalCategoryDao();
        List<AnimalCategory> animalCategoryList =  animalCategoryDao.loadAll();

        if ( animalCategoryList.size() > 0 ){
            // Stop if already has records
            return false;
        }

        Toast.makeText( this, "Creating new Animals and categories from scratch", Toast.LENGTH_LONG ).show();

        String categories[] = {
                "elephant",
                "feline",
                "bird"
        };

        for (String category : categories) {
            AnimalCategory animalCategory = new AnimalCategory();
            animalCategory.setName(category);
            Log.d("__TAG__", "initCategories: idBefore="+animalCategory.getId());
            animalCategoryDao.insert( animalCategory );
            Log.d("__TAG__", "initCategories: idAfter="+animalCategory.getId());
        }

        return true;
    }

    public void initAnimals(){
        AnimalCategoryDao animalCategoryDao = daoSession.getAnimalCategoryDao();
        AnimalDao animalDao = daoSession.getAnimalDao();

        // Get categories
        AnimalCategory elephant = animalCategoryDao.queryBuilder().where(AnimalCategoryDao.Properties.Name.eq( "elephant" )).unique();
        AnimalCategory feline = animalCategoryDao.queryBuilder().where(AnimalCategoryDao.Properties.Name.eq( "feline" )).unique();
        AnimalCategory bird = animalCategoryDao.queryBuilder().where(AnimalCategoryDao.Properties.Name.eq( "bird" )).unique();


        Animal animal = new Animal();
        animal.setAnimalCategory(elephant);
        animal.setAnimalName("Pam");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.elephant )));
        animal.setWeight((float)2000.5);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(elephant);
        animal.setAnimalName("Jeffry");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.elephant1 )));
        animal.setWeight((float)1700.5);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(feline);
        animal.setAnimalName("Sam");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.lion1 )));
        animal.setWeight((float)500);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(feline);
        animal.setAnimalName("Simba");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.lion2 )));
        animal.setWeight((float)800);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(feline);
        animal.setAnimalName("Jeffry");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.lion3 )));
        animal.setWeight((float)700);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(bird);
        animal.setAnimalName("Henry");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.bird )));
        animal.setWeight((float)1.5);
        animalDao.insert(animal);


        animal = new Animal();
        animal.setAnimalCategory(bird);
        animal.setAnimalName("Beyonce");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.bird1 )));
        animal.setWeight((float)1.3);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(bird);
        animal.setAnimalName("Keg");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.bird2 )));
        animal.setWeight((float)2.4);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(bird);
        animal.setAnimalName("Hank");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.bird3 )));
        animal.setWeight((float)7.7);
        animalDao.insert(animal);

        animal = new Animal();
        animal.setAnimalCategory(bird);
        animal.setAnimalName("Imposta");
        animal.setAnimalPhoto(BitmapHelper.bmp2bytes(BitmapFactory.decodeResource( getResources(), R.drawable.bird4 )));
        animal.setWeight((float)180.3);
        animalDao.insert(animal);

    }

    public void goCategories(View view) {
        Intent intent = new Intent( getApplicationContext(), CategoryActivity.class );
        startActivity( intent );
    }
}
