package com.example.UnionCoop.network;

import com.example.UnionCoop.model.RepositoryResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
public interface RepoApiService {

    @GET("repositories")
    Observable <List<RepositoryResponse>> getReposData(@Query("language") String language
    ,@Query("since") String since,@Query("spoken_language_code") String langspoken_language_codeuage);
}
