package com.example.UnionCoop.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.UnionCoop.model.RepositoryResponse;
import com.example.UnionCoop.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */

public class RepoDataViewModel extends ViewModel {
    private static final String TAG = "RepoDataViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<RepositoryResponse>> mRepoList = new MutableLiveData<ArrayList<RepositoryResponse>>();
    private LiveData<List<RepositoryResponse>> favoriteRepoList = null;

    @ViewModelInject
    public RepoDataViewModel(Repository repository) {
        this.repository = repository;
        favoriteRepoList = repository.getFavoriteRepo();
    }

    public MutableLiveData<ArrayList<RepositoryResponse>> getmRepoList() {
        return mRepoList;
    }

    public void getRepos(){
        repository.getReposData(null,"daily",null)
                .subscribeOn(Schedulers.io())
                .map(new Function<List<RepositoryResponse>, ArrayList<RepositoryResponse>>() {
                    @Override
                    public ArrayList<RepositoryResponse> apply(List<RepositoryResponse> repositoryResponses) throws Throwable {

                        ArrayList<RepositoryResponse> list = (ArrayList<RepositoryResponse>) repositoryResponses;
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> mRepoList.setValue(result),
                        error-> Log.e(TAG, "getRepos: " + error.getMessage() ));
    }

    public void insertRepo(RepositoryResponse repositoryResponse){
        repository.insertRepo(repositoryResponse);
    }
    public void deleteRepo(String repoName){
        repository.deleteRepo(repoName);
    }

    public LiveData<List<RepositoryResponse>> getFavoriteRepoList() {
        return favoriteRepoList;
    }

    public void getFavoriteRepo(){
       favoriteRepoList = repository.getFavoriteRepo();
    }



}
