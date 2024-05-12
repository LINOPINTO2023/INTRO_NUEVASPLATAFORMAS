package com.idnp2024a.loginsample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Obtener el valor del campo de usuario del Intent
        String username = getIntent().getStringExtra("username");

        // Mostrar el valor en el TextView de bienvenida
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Bienvenido " + username);
    }
}
