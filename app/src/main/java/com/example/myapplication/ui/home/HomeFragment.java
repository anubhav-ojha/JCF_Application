package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import Adapters.Exercise_Adapter;
import Models.Exercise_Model;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    RecyclerView muscleGroupRecyclerView ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        muscleGroupRecyclerView = binding.homeFragmentRecyclerView;

        ArrayList<Exercise_Model> list = new ArrayList<>() ;
        Exercise_Adapter adapter = new Exercise_Adapter(list,getContext());
        muscleGroupRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        muscleGroupRecyclerView.setAdapter(adapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}