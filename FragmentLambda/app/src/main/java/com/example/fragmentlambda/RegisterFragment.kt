package com.example.fragmentlambda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {

    private var onRegister: ((User) -> Unit)? = null

    fun setOnRegisterListener(onRegister: (User) -> Unit) {
        this.onRegister = onRegister
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val edtFirstname = view.findViewById<EditText>(R.id.edtFirstname)
        val edtLastname = view.findViewById<EditText>(R.id.edtLastname)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val edtPhone = view.findViewById<EditText>(R.id.edtPhone)
        val edtUsername = view.findViewById<EditText>(R.id.edtUsername)
        val edtPassword = view.findViewById<EditText>(R.id.edtPassword)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val user = User(
                firstname = edtFirstname.text.toString(),
                lastname = edtLastname.text.toString(),
                email = edtEmail.text.toString(),
                phone = edtPhone.text.toString(),
                username = edtUsername.text.toString(),
                password = edtPassword.text.toString()
            )

            onRegister?.invoke(user)
        }

        return view
    }
}

data class User(
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val username: String,
    val password: String
)
