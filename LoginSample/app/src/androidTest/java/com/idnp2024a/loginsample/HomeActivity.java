package com.idnp2024a.loginsample;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        String accountEntityJson = getIntent().getStringExtra("ACCOUNT");
        Log.d("HomeActivity", accountEntityJson);

        Gson gson = new Gson();
        AccountEntity accountEntity = gson.fromJson(accountEntityJson, AccountEntity.class);

        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Bienvenido " + accountEntity.getFirstname() + " " + accountEntity.getLastname() + "\n" +
                "Correo: " + accountEntity.getEmail() + "\n" +
                "Teléfono: " + accountEntity.getPhone() + "\n" +
                "Usuario: " + accountEntity.getUsername());
    }
}
