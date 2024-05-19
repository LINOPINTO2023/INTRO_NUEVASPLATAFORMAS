package com.idnp2024a.loginsample;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
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

    private static String TAG="MainActivity";
    private ActivityMainBinding binding;
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
                if(edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Bienvenido a mi App", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Bienvenido a mi App");
                    //Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    //intent.putExtra("username", edtUsername.getText().toString());
                    //startActivity(intent);
                    //finish();
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
                    Integer resultCode=activityResult.getResultCode();
                    if(resultCode==AccountActivity.ACCOUNT_ACCEPTAR){
                        Intent data = activityResult.getData();
                        //para recuperar datos
                        String account_record= data.getStringExtra(AccountActivity.ACCOUNT_RECORD);

                        Gson gson = new Gson();
                        AccountEntity accountEntity= gson.fromJson(account_record,AccountEntity.class);
                        String firtsname = accountEntity.getFirstname();
                        Toast.makeText(getApplicationContext(),"Nombre:"+firtsname,Toast.LENGTH_SHORT).show();
                        Log.d("LoginActivity","Nombre:"+firtsname);
                    }
                    else if(resultCode == AccountActivity.ACCOUNT_CANCELAR){
                        Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_LONG).show();
                        Log.d("LoginActivity","Cancelado");
                    }
                    //Intent data = activityResult.getData();
                }
            }
    );
}
