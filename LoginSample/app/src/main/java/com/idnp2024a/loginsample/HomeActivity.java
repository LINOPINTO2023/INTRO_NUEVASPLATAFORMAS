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

        String accountEntityString = getIntent().getStringExtra("ACCOUNT");
        Log.d("HomeActivity", accountEntityString);

        if (accountEntityString != null) {
            Gson gson = new Gson();
            AccountEntity accountEntity = gson.fromJson(accountEntityString, AccountEntity.class);

            TextView txtWelcome = findViewById(R.id.txtWelcome);
            txtWelcome.setText("Bienvenido " + accountEntity.getFirstname() + " " + accountEntity.getLastname());

            TextView txtEmail = findViewById(R.id.txtEmail);
            txtEmail.setText("Email: " + accountEntity.getEmail());

            TextView txtPhone = findViewById(R.id.txtPhone);
            txtPhone.setText("Telefono: " + accountEntity.getPhone());

            TextView txtUsername = findViewById(R.id.txtUsername);
            txtUsername.setText("Usuario: " + accountEntity.getUsername());
        }
    }
}
