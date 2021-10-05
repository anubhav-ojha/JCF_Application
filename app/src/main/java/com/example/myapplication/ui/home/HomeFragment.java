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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

import Adapters.Exercise_Adapter;
import Models.Exercise_Model;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    RecyclerView muscleGroupRecyclerView ;
    FirebaseFirestore db;
    ArrayList<Exercise_Model> datalist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        muscleGroupRecyclerView = binding.homeFragmentRecyclerView;
        db = FirebaseFirestore.getInstance() ;
        datalist = new ArrayList<>();

        Exercise_Adapter adapter = new Exercise_Adapter(datalist,getContext());
        muscleGroupRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        muscleGroupRecyclerView.setAdapter(adapter);

        db.collection("MuscleGroup").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                      List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                      for(DocumentSnapshot d:list)
                      {
                          Exercise_Model obj = d.toObject(Exercise_Model.class) ;
                          datalist.add(obj);
                      }
                      adapter.notifyDataSetChanged();
                    }
                });




        //ArrayList<Exercise_Model> list = new ArrayList<>() ;
        //for(int i = 0; i< 10; i++) {
         //   list.add(new Exercise_Model(" ", "ABhi"));
       // }
      //  Exercise_Adapter adapter = new Exercise_Adapter(list,getContext());
       // muscleGroupRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
       // muscleGroupRecyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}