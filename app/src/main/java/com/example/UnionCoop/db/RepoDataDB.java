package com.example.UnionCoop.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.UnionCoop.model.RepositoryResponse;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
@Database(entities = {RepositoryResponse.class},version = 2,exportSchema = false)
public abstract class RepoDataDB extends RoomDatabase {
        public abstract RepoDao pokeDao();
}
