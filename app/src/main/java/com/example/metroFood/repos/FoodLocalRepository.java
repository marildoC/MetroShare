package com.example.metroFood.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.metroFood.daos.FoodDao;
import com.example.metroFood.db.FoodDonarDb;
import com.example.metroFood.entities.Food;

public class FoodLocalRepository {

    private FoodDao foodDao;

    public FoodLocalRepository(Context context){

        foodDao= FoodDonarDb.getDb(context).getStudentDao();
    }

    public void addStudent(Food food){

        foodDao.insertFoodDonar(food);

    }


    public LiveData<List<Food>> getAllDonars(){
        return foodDao.getAllDonars();
    }

}
