package com.example.UnionCoop.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.UnionCoop.databinding.ActivityMainBinding;
import com.example.UnionCoop.ui.fragments.ConnectionLost;
import com.example.UnionCoop.ui.fragments.Favorites;
import com.example.UnionCoop.ui.fragments.Home;
import com.example.UnionCoop.R;


import java.net.InetAddress;

import dagger.hilt.android.AndroidEntryPoint;
/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isFavoriteListVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar.getRoot());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (!isNetworkConnected()/*||!isInternetAvailable()*/){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                    .commit();

        }else{
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                .commit();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.openFav){
            isFavoriteListVisible = false;

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Favorites())
                            .commit();
        }
        if (item.getItemId() == R.id.openHome){
            isFavoriteListVisible = false;
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }
}
