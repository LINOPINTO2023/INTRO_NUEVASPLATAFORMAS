package com.idnp2024a.loginsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccountActivity extends AppCompatActivity {

    //Clase AccountActivity: Es una actividad que permite al usuario crear una nueva cuenta
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate: Método que se ejecuta cuando la actividad se crea. Aquí configuramos la interfaz de usuario y los manejadores de eventos.
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAceptar = findViewById(R.id.btnAceptar);
        Button btnCancelar= findViewById(R.id.btnCancelar);

        EditText edtFirstname = findViewById(R.id.edtFirstname);
        EditText editLastname = findViewById(R.id.editLastname);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText edtUsername2 = findViewById(R.id.edtUsername2);
        EditText edtPassword2 = findViewById(R.id.edtPassword2);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountEntity account = new AccountEntity();
                account.setFirstname(edtFirstname.getText().toString());
                account.setLastname(editLastname.getText().toString());
                account.setEmail(edtEmail.getText().toString());
                account.setPhone(editTextPhone.getText().toString());
                account.setUsername(edtUsername2.getText().toString());
                account.setPassword(edtPassword2.getText().toString());

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("account", account);
                startActivity(intent);
            }
        });
    }
}
