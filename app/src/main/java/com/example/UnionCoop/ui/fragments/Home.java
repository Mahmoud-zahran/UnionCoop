package com.example.UnionCoop.ui.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.UnionCoop.R;
import com.example.UnionCoop.adapters.RepoDataAdapter;


import com.example.UnionCoop.databinding.HomeBinding;
import com.example.UnionCoop.model.RepositoryResponse;
import com.example.UnionCoop.viewmodel.RepoDataViewModel;


import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */

@AndroidEntryPoint
public class Home extends Fragment {
    private static final String TAG = "Home";
    private HomeBinding binding;
    private RepoDataViewModel viewModel;
    private RepoDataAdapter adapter;
    private ArrayList<RepositoryResponse> repoDataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = HomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RepoDataViewModel.class);

        initRecyclerView();
        observeData();
        setUpItemTouchHelper();
        viewModel.getRepos();

        if (!isNetworkConnected()/*||!isInternetAvailable()*/){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                    .commit();

        }
        binding.pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               viewModel.getRepos();// your code
                binding.pullToRefresh.setRefreshing(false);
                if (!isNetworkConnected()/*||!isInternetAvailable()*/){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                            .commit();

                }
            }
        });
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedRepoPosition = viewHolder.getAdapterPosition();
                RepositoryResponse repositoryResponse = adapter.getRepoAt(swipedRepoPosition);
                viewModel.insertRepo(repositoryResponse);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(),"Repo added to favorites.",Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.repoRecyclerView);
    }


    private void observeData() {
        viewModel.getmRepoList().observe(getViewLifecycleOwner(), (Observer<? super ArrayList<RepositoryResponse>>) new Observer<ArrayList<RepositoryResponse>>() {
            @Override
            public void onChanged(ArrayList<RepositoryResponse> repositoryResponses) {
                ArrayList<RepositoryResponse> repoData= repositoryResponses;
                if (repoData.isEmpty()){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                            .commit();
                }
                Log.e(TAG, "onChanged: " + repoData.size() );
                adapter.updateList(repoData);
            }
        });
    }

    private void initRecyclerView() {
        binding.repoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RepoDataAdapter(getContext(), repoDataList);
        binding.repoRecyclerView.setAdapter(adapter);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
