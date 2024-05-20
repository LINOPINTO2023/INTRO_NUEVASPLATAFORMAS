package com.idnp2024a.loginsample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.idnp2024a.loginsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private static String TAG="LoginActivity";
    private ActivityMainBinding binding;
    private AccountEntity accountEntity;
    private String accountEntityString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText edtUsername = binding.edtUsername;
        EditText edtPassword = binding.edtPassword;
        Button btnLogin = binding.btnLogin;
        Button btnAddAccount = binding.btnAddAccount;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
                String savedUserJson = prefs.getString("account", null);
                if (savedUserJson != null) {
                    Gson gson = new Gson();
                    AccountEntity savedAccount = gson.fromJson(savedUserJson, AccountEntity.class);
                    if (edtUsername.getText().toString().equals(savedAccount.getUsername()) &&
                            edtPassword.getText().toString().equals(savedAccount.getPassword())) {
                        Toast.makeText(getApplicationContext(), "Bienvenido a mi App", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Bienvenido a mi App");
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("ACCOUNT", savedUserJson);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error en la Autenticacion", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Error en la Autenticacion");
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error en la Autenticacion", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Error en la Autenticacion");
                }
            }
        });

        btnAddAccount.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            activityResultLauncher.launch(intent);
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    Integer resultCode = activityResult.getResultCode();
                    Log.d("LoginActivity","resultCode:"+resultCode);
                    if(resultCode == AccountActivity.ACCOUNT_ACCEPTAR){
                        Intent data = activityResult.getData();
                        accountEntityString = data.getStringExtra(AccountActivity.ACCOUNT_RECORD);

                        Gson gson = new Gson();
                        accountEntity = gson.fromJson(accountEntityString, AccountEntity.class);
                        String firstname = accountEntity.getFirstname();

                        SharedPreferences prefs = getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("account", accountEntityString);
                        editor.apply();

                        Toast.makeText(getApplicationContext(),"Nombre:"+firstname,Toast.LENGTH_SHORT).show();
                        Log.d("LoginActivity","Nombre:"+firstname);
                    } else if(resultCode == AccountActivity.ACCOUNT_CANCELAR){
                        Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_LONG).show();
                        Log.d("LoginActivity","Cancelado");
                    }
                }
            }
    );
}
