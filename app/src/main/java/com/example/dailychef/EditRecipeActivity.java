package com.example.dailychef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class EditRecipeActivity extends AppCompatActivity {

    ImageButton btnBack, btnDelete;

    EditText recipeName, recipeDescription;

    Switch checkBoxShare;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

        btnBack = findViewById(R.id.btnBackButtonEdit);
        btnDelete = findViewById(R.id.btnDeleteRecipe);

        recipeName = findViewById(R.id.txtRecipeNameEditRecipe);
        recipeDescription = findViewById(R.id.txtRecipeDescriptionEditRecipe);
        checkBoxShare = findViewById(R.id.checkBoxShareEditRecipe);

        String recipeId = getIntent().getStringExtra("recipeId");

        db = AppDatabase.getDbInstance(getApplicationContext());


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.receitaDao().deleteRecipe(db.receitaDao().getReceitaById(Integer.parseInt(recipeId)));
                Toast.makeText(getApplicationContext(), "Recipe deleted successfully!", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        recipeName.setText(db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).recipeName);
        recipeDescription.setText(db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).recipeDescription);
        Boolean checked = db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).shared;
        checkBoxShare.setChecked(checked);
    }
}