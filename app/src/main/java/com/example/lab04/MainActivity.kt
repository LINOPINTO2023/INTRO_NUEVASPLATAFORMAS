package com.example.lab04

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.myapp.RegisterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtMensaje = findViewById<TextView>(R.id.txtMensaje)

        val buttonFragment1 = findViewById<Button>(R.id.buttonFragment1)
        val buttonFragment2 = findViewById<Button>(R.id.buttonFragment2)

        buttonFragment1.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.frameLayout, BlankFragment())
            }
        }

        buttonFragment2.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.frameLayout, SecondFragment())
            }
        }

        val registerFragment = RegisterFragment()
        registerFragment.onRegisterListener = { user ->
            val userInfo = "Name: ${user.name}, Email: ${user.email}, Password: ${user.password}"
            txtMensaje.text = userInfo
        }

        supportFragmentManager.commit {
            replace(R.id.frameLayout, registerFragment)
        }
    }
}
