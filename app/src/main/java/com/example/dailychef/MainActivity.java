package com.example.dailychef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView noAccount;

    EditText txtUsername, txtPassword;

    AppDatabase db;

    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDbInstance(getApplicationContext());

        btnLogin = findViewById(R.id.btnLogin);

        txtUsername = findViewById(R.id.UsernameField);
        txtPassword = findViewById(R.id.passwordField);

        noAccount = findViewById(R.id.noAccount);

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verifyText(txtUsername) || !verifyText(txtPassword)){
                    Toast.makeText(getApplicationContext(), "Fill all fields with info", Toast.LENGTH_LONG).show();
                    return;
                }
                User user = db.userDao().login(txtUsername.getText().toString(), txtPassword.getText().toString());
                if(user == null){
                    Toast.makeText(getApplicationContext(), "You provided a wrong username or password", Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(getApplicationContext(), "Login successfully!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, BackgroundActivity.class);
                intent.putExtra("username", txtUsername.getText().toString());
                startActivity(intent);

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