package com.example.dailychef.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.dailychef.DB.AppDatabase;
import com.example.dailychef.DB.Receita;
import com.example.dailychef.R;

public class EditRecipeActivity extends AppCompatActivity {

    ImageButton btnBack, btnDelete;

    Button btnEditar;

    EditText recipeName, recipeDescription, wayToDo;

    Switch checkBoxShare;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

        btnBack = findViewById(R.id.btnBackButtonEdit);
        btnDelete = findViewById(R.id.btnDeleteRecipe);
        btnEditar = findViewById(R.id.btnEditRecipe);

        recipeName = findViewById(R.id.txtRecipeNameEditRecipe);
        recipeDescription = findViewById(R.id.txtRecipeDescriptionEditRecipe);
        checkBoxShare = findViewById(R.id.checkBoxShareEditRecipe);
        wayToDo = findViewById(R.id.txtRecipeTutorial);

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

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeOwner = db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).recipeOwner;
                String createdAt = db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).createdAt;
                Receita receita = new Receita(Integer.parseInt(recipeId) ,recipeName.getText().toString(), recipeDescription.getText().toString(), wayToDo.getText().toString(), checkBoxShare.isChecked(), recipeOwner, createdAt);
                db.receitaDao().updateRecipe(receita);
                finish();
            }
        });


        recipeName.setText(db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).recipeName);
        recipeDescription.setText(db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).recipeDescription);
        Boolean checked = db.receitaDao().getReceitaById(Integer.parseInt(recipeId)).shared;
        checkBoxShare.setChecked(checked);
    }
}