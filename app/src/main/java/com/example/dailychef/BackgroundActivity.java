package com.example.dailychef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dailychef.databinding.ActivityBackgroundBinding;
import com.example.dailychef.databinding.ActivityMainBinding;

public class BackgroundActivity extends AppCompatActivity {

    ActivityBackgroundBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBackgroundBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ProfileFragment());
        
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.topVoted:
                    replaceFragment(new TopVotedRecipesFragment());
                    break;
                case R.id.sharedRecipes:
                    replaceFragment(new SharedRecipesFragment());
                    break;
                case R.id.myRecipes:
                    replaceFragment(new MyRecipesFragment());
                    break;
                case R.id.myProfile:
                    Bundle bundle = new Bundle();
                    Intent intent = getIntent();
                    String username = intent.getStringExtra("username");
                    bundle.putString("username", username.toString());
                    ProfileFragment profileFragment = new ProfileFragment();
                    profileFragment.setArguments(bundle);
                    replaceFragment(profileFragment);
                    break;
            }

            return true;
        });
        binding.bottomNavigationView.setSelectedItemId(R.id.myProfile);

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}