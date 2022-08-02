package com.example.pgddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registration extends AppCompatActivity {

    public static ArrayList<Person> data = new ArrayList<>();

    EditText userName;
    EditText password;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName_S = userName.getText().toString();
                String password_S = password.getText().toString();

                data.add(new Person(userName_S, password_S));
                Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                Intent loginIntent = new Intent(Registration.this, Login.class);
                startActivity(loginIntent);
            }
        });

    }
}