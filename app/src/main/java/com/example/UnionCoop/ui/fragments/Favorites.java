package com.example.UnionCoop.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.UnionCoop.adapters.RepoDataAdapter;

import com.example.UnionCoop.databinding.FavoritesBinding;

import com.example.UnionCoop.model.RepositoryResponse;
import com.example.UnionCoop.viewmodel.RepoDataViewModel;


import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * Created by Mahmoud Zahran on 3,Oct,2020
 */

@AndroidEntryPoint
public class Favorites extends Fragment {
    private FavoritesBinding binding;
    private RepoDataViewModel viewModel;
    private RepoDataAdapter adapter;
    private ArrayList<RepositoryResponse> repoDataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FavoritesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RepoDataViewModel.class);

        initRecyclerView();
        setUpItemTouchHelper();
        observeData();

    }

    private void observeData() {
        viewModel.getFavoriteRepoList().observe(getViewLifecycleOwner(), new Observer<List<RepositoryResponse>>() {
            @Override
            public void onChanged(List<RepositoryResponse> repoData) {

                if(repoData == null || repoData.size() == 0)
                    binding.noFavoritesText.setVisibility(View.VISIBLE);
                else{
                    ArrayList<RepositoryResponse> list = new ArrayList<>();
                    list.addAll(repoData);
                    adapter.updateList(list);
                }
            }
        });
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedRepoPosition = viewHolder.getAdapterPosition();
                RepositoryResponse repoData = adapter.getRepoAt(swipedRepoPosition);
                viewModel.deleteRepo(repoData.getName());
                Toast.makeText(getContext(),"Repo removed from favorites.",Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.favoritesRecyclerView);
    }


    private void initRecyclerView() {
        binding.favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RepoDataAdapter(getContext(), repoDataList);
        binding.favoritesRecyclerView.setAdapter(adapter);
    }

}
