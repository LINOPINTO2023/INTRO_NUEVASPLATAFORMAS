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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Aquí debes obtener una referencia a los EditText y al botón btnOk
        EditText edtFirstname = findViewById(R.id.edtFirstname);
        EditText editLastname = findViewById(R.id.editLastname);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText edtUsername2 = findViewById(R.id.edtUsername2);
        EditText edtPassword2 = findViewById(R.id.edtPassword2);

        // Aquí debes obtener una referencia al botón btnOk y configurar su OnClickListener
        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Coloca aquí el código para manejar el click del botón btnOk
                // Crear un nuevo objeto AccountEntity
                AccountEntity account = new AccountEntity();

                // Obtener los valores de los EditText y establecerlos en el objeto AccountEntity
                account.setFirstname(edtFirstname.getText().toString());
                account.setLastname(editLastname.getText().toString());
                account.setEmail(edtEmail.getText().toString());
                account.setPhone(editTextPhone.getText().toString());
                account.setUsername(edtUsername2.getText().toString());
                account.setPassword(edtPassword2.getText().toString());

                // Crear un intent y adjuntar el objeto AccountEntity como extra
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("account", account);
                startActivity(intent);
            }
        });
    }
}