package com.example.UnionCoop.repository;

import androidx.lifecycle.LiveData;

import com.example.UnionCoop.db.RepoDao;

import com.example.UnionCoop.model.RepositoryResponse;
import com.example.UnionCoop.network.RepoApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */

public class Repository {

    private RepoDao repoDao;
    private RepoApiService apiService;

    @Inject
    public Repository(RepoDao repoDao, RepoApiService apiService) {
        this.repoDao = repoDao;
        this.apiService = apiService;
    }


    public Observable<List<RepositoryResponse>> getReposData(String language
            , String since,String langspoken_language_codeuage){
        return apiService.getReposData(language,since,langspoken_language_codeuage);
    }

    public void insertRepo(RepositoryResponse repositoryResponse){
        repoDao.insertRepoDao(repositoryResponse);
    }

    public void deleteRepo(String repo)
    {
        repoDao.deleteRepoDao(repo);
    }

    public void deleteAll(){
        repoDao.deleteAll();
    }

    public LiveData<List<RepositoryResponse>> getFavoriteRepo(){
        return repoDao.getFavoriteRepos();
    }
}
