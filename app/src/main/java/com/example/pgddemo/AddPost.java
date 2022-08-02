package com.example.pgddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPost extends AppCompatActivity {

    String userName;
    EditText storyEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            userName = bundle.getString("user");
        }

        storyEditText = findViewById(R.id.story);
        button = findViewById(R.id.submitPostButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = storyEditText.getText().toString();
                Post post = new Post(userName, text);
                Home.posts.add(post);
                Toast.makeText(AddPost.this, "Story Created", Toast.LENGTH_LONG).show();
                Intent homePage = new Intent(AddPost.this, Home.class);
                startActivity(homePage);
            }
        });

    }
}