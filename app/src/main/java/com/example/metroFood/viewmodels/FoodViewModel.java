package com.example.metroFood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.metroFood.entities.Food;
import com.example.metroFood.repos.FoodLocalRepository;

public class FoodViewModel  extends AndroidViewModel {


    private FoodLocalRepository repository;


    public FoodViewModel(@NonNull Application application) {
        super(application);
        repository = new FoodLocalRepository(application);

    }

    public void addFoodDonar(Food food) {

        repository.addStudent(food);

    }

    public LiveData<List<Food>> getAllFoodDonar() {
        return repository.getAllDonars();
    }
}