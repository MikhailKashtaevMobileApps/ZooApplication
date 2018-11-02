package com.example.mike.zooapplicatoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mike.zooapplicatoin.adapter.CustomCategoryAdapter;
import com.example.mike.zooapplicatoin.model.AnimalCategory;
import com.example.mike.zooapplicatoin.model.AnimalCategoryDao;
import com.example.mike.zooapplicatoin.model.DaoMaster;
import com.example.mike.zooapplicatoin.model.DaoSession;
import com.example.mike.zooapplicatoin.utils.DBHelper;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        daoSession = DBHelper.initDao(getApplicationContext());

        AnimalCategoryDao animalCategoryDao = daoSession.getAnimalCategoryDao();
        List<AnimalCategory> animalCategories = animalCategoryDao.loadAll();

        ListView lvCategory = findViewById( R.id.lvCategories );
        CustomCategoryAdapter adapter = new CustomCategoryAdapter( getApplicationContext(), R.layout.list_item_category, animalCategories );
        lvCategory.setAdapter(adapter);
    }

    public void selectCategory(){

    }
}
