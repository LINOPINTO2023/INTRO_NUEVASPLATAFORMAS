package com.example.fragmentlambdajava;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private TextView txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensaje = findViewById(R.id.txtMensaje);

        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.setOnRegisterListener(user -> {
            String userInfo = "Nombre: " + user.getFirstname() + " " + user.getLastname() +
                    "\nCorreo: " + user.getEmail() +
                    "\nTeléfono: " + user.getPhone() +
                    "\nUsuario: " + user.getUsername();
            txtMensaje.setText(userInfo);
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, registerFragment);
        fragmentTransaction.commit();
    }
}
