package com.example.UnionCoop.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.UnionCoop.model.RepositoryResponse;

import java.util.List;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */

@Dao
public interface RepoDao {

    @Insert
    void insertRepoDao(RepositoryResponse repositoryResponse);

    @Query("DELETE FROM favorite_table WHERE name = :author")
    void deleteRepoDao(String author);

    @Query("DELETE FROM favorite_table")
    void deleteAll();

    @Query("SELECT * FROM favorite_table")
    LiveData<List<RepositoryResponse>> getFavoriteRepos();
}
