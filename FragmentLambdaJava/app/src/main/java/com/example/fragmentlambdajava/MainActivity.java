package com.example.fragmentlambdajava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    private OnRegisterListener onRegisterListener;

    public interface OnRegisterListener {
        void onRegister(User user);
    }

    public void setOnRegisterListener(OnRegisterListener onRegisterListener) {
        this.onRegisterListener = onRegisterListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText edtFirstname = view.findViewById(R.id.edtFirstname);
        EditText edtLastname = view.findViewById(R.id.edtLastname);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtPhone = view.findViewById(R.id.edtPhone);
        EditText edtUsername = view.findViewById(R.id.edtUsername);
        EditText edtPassword = view.findViewById(R.id.edtPassword);
        Button btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            User user = new User(
                    edtFirstname.getText().toString(),
                    edtLastname.getText().toString(),
                    edtEmail.getText().toString(),
                    edtPhone.getText().toString(),
                    edtUsername.getText().toString(),
                    edtPassword.getText().toString()
            );

            if (onRegisterListener != null) {
                onRegisterListener.onRegister(user);
            }
        });

        return view;
    }
}
