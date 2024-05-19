package com.idnp2024a.loginsample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String username = getIntent().getStringExtra("username");
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Bienvenido " + username);
    }
}
