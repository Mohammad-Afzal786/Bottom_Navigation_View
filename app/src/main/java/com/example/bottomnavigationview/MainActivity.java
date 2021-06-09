package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottomnavigationview.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.bottom_nav);
        FragmentTransaction homeTrans=getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.content,new Home_Fragment());
        homeTrans.commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        fragmentTransaction.replace(R.id.content,new Home_Fragment());

                        break;
                    case R.id.search:
                        fragmentTransaction.replace(R.id.content, new Search_Fragment());
                        break;
                    case R.id.cart:
                        fragmentTransaction.replace(R.id.content,new Cart_Fragment());
                        break;
                    case R.id.setting:
                        fragmentTransaction.replace(R.id.content,new Setting_Fragment());
                        break;
                }
                fragmentTransaction.commit();
                return true;

            }
        });
    }
}