package com.example.dailychef;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class NewRecipeActivity extends AppCompatActivity {

    String username;

    EditText txtRecipeName, txtRecipeDescription, txtRecipeTutorial;

    Switch shareRecipe;

    Button btnAddRecipe;
    ImageButton backButton;

    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        username = getIntent().getStringExtra("username");


        txtRecipeName = findViewById(R.id.txtRecipeNameEditRecipe);
        txtRecipeTutorial = findViewById(R.id.txtRecipeTutorial);
        txtRecipeDescription = findViewById(R.id.txtRecipeDescriptionEditRecipe);

        shareRecipe = findViewById(R.id.checkBoxShareEditRecipe);

        btnAddRecipe = findViewById(R.id.btnAddNewRecipe);

        backButton = findViewById(R.id.backButton);

        db = AppDatabase.getDbInstance(getApplicationContext());

        btnAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empty(txtRecipeName) || empty(txtRecipeDescription) || empty(txtRecipeTutorial)){
                    Toast.makeText(getApplicationContext(), "Please fill all fields.", Toast.LENGTH_LONG).show();
                    return;
                }

                Receita receita = new Receita(txtRecipeName.getText().toString(), txtRecipeDescription.getText().toString(), txtRecipeTutorial.getText().toString(), shareRecipe.isChecked(), username);

                db.receitaDao().insertRecipe(receita);

                Toast.makeText(getApplicationContext(), "Recipe added successfully!", Toast.LENGTH_LONG).show();
                finish();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    boolean empty(EditText txtBox){
        if(txtBox.getText().length() == 0){
            return true;
        }
        return false;
    }
}