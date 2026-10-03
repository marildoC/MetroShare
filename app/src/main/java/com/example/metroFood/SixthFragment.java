package com.example.metroFood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

import com.example.metroFood.data.Datagenerate;
import com.example.metroFood.databinding.FragmentSixthBinding;
import com.example.metroFood.entities.Food;
import com.example.metroFood.viewmodels.FoodViewModel;



public class SixthFragment extends Fragment {

    private String gender = Food.MALE;
    private List<String> foodGrup = Datagenerate.foodGroup;
    private String foodGrupName;
    private FragmentSixthBinding binding;
    private FoodViewModel viewModel;

    public SixthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSixthBinding.inflate(inflater);
        viewModel=new ViewModelProvider(requireActivity()).get(FoodViewModel.class);


        //SpinnerMethod
        binding.foodSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                foodGrupName = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getActivity(), courseTitle, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        binding.ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String Name = binding.name.getText().toString(); //NAME
                final String sub = binding.sub.getText().toString(); //SUBJECT
                final String phone = binding.msg.getText().toString(); //MESSAGE
                final String email = "rasha.is19@sahyadri.edu.in";


                boolean check = validate(Name);
                if(check == true)
                {
                    String mail = "mailto:" + email +
                            "?&subject=" + Uri.encode(sub) +
                            "&body=" + Uri.encode(phone);
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse(mail));
                    try {
                        startActivity(Intent.createChooser(intent,"Send Email.."));
                    }
                    catch (Exception e)
                    {

                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(getActivity(), studentName, Toast.LENGTH_SHORT).show();
            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    private Boolean validate(String Name) {
        if (Name.length() == 0 ) {
            binding.name.requestFocus();
            binding.name.setError("FIELD SHOULD NOT BE EMPTY");
            return false;
        } else if (!Name.matches("[A-Za-z]+")) {
            binding.name.requestFocus();
            binding.name.setError("INVALID NAME");
            return false;
        }
        else
        {
            return true;
        }
    }
}