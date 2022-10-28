package com.example.dailychef.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailychef.DB.AppDatabase;
import com.example.dailychef.DB.User;
import com.example.dailychef.R;

public class RegisterActivity extends AppCompatActivity {

    EditText txtUsername, txtEmail, txtPassword, txtConfPassword;
    TextView existAcc;
    Button btnRegister;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = AppDatabase.getDbInstance(getApplicationContext());

        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtConfPassword = findViewById(R.id.txtRepeatPassword);
        txtPassword = findViewById(R.id.txtPassword);

        existAcc = findViewById(R.id.existAcc);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verifyText(txtUsername) || !verifyText(txtEmail) || !verifyText(txtPassword) || !verifyText(txtConfPassword)){
                    Toast.makeText(getApplicationContext(), "Fill all fields with info", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!txtPassword.getText().toString().equals(txtConfPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Passwords must match!", Toast.LENGTH_LONG).show();
                    return;
                }

                if(db.userDao().findByUserLogin(txtUsername.getText().toString()) != null){
                    Toast.makeText(getApplicationContext(), "This user already exists! Try to login", Toast.LENGTH_LONG).show();
                    return;
                }

                User user = new User(txtUsername.getText().toString(), txtUsername.getText().toString(), txtEmail.getText().toString(), txtPassword.getText().toString());
                db.userDao().insert(user);
                Toast.makeText(getApplicationContext(), "User registered successfully!", Toast.LENGTH_LONG).show();
            }
        });

        existAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public static boolean verifyText(EditText txtBox){
        if(txtBox.getText().length() == 0){
            return false;
        }
        return true;
    }
}