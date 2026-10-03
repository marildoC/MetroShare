package com.example.metroFood;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import com.example.metroFood.adapter.MyAdapter;
import com.example.metroFood.databinding.FragmentThirdBinding;
import com.example.metroFood.entities.Food;
import com.example.metroFood.viewmodels.FoodViewModel;


public class ThirdFragment extends Fragment {

       private FragmentThirdBinding binding;
       private MyAdapter adapter;
       private FoodViewModel viewModel;
    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentThirdBinding.inflate(inflater);
        viewModel=new ViewModelProvider(requireActivity()).get(FoodViewModel.class);
        adapter = new MyAdapter(this);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        binding.donarRv.setAdapter(adapter);
        binding.donarRv.setLayoutManager(llm);
        viewModel.getAllFoodDonar().observe(getViewLifecycleOwner(), new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foodList) {
                adapter.submitNewList(foodList);
                Toast.makeText(getContext(), "Donors Available :"+foodList.size(), Toast.LENGTH_SHORT).show();
            }
        });




        return binding.getRoot();
    }
}