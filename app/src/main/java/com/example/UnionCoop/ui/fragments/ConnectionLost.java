package com.example.UnionCoop.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UnionCoop.R;
import com.example.UnionCoop.databinding.FragmentConnectionLostBinding;
import com.example.UnionCoop.databinding.HomeBinding;

import dagger.hilt.android.AndroidEntryPoint;
/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
@AndroidEntryPoint
public class ConnectionLost extends Fragment {

    private FragmentConnectionLostBinding binding;


    public ConnectionLost() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentConnectionLostBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().recreate();//getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                     //   .commit();
            }
        });
    }

}