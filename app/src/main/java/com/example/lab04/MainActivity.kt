package com.example.lab04

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private lateinit var txtMensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtMensaje = findViewById(R.id.txtMensaje)

        findViewById<Button>(R.id.buttonFragment1).setOnClickListener {
            val fragment1 = BlankFragment.newInstance(responseFragment1)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.frameLayout, fragment1)
            }
        }

        findViewById<Button>(R.id.buttonFragment2).setOnClickListener {
            val fragment2 = SecondFragment.newInstance(responseFragment2)
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.frameLayout, fragment2)
            }
        }
    }

    private val responseFragment1: (String) -> Unit = { mensaje ->
        txtMensaje.text = "${txtMensaje.text}\nFragment 1 dice: $mensaje"
    }

    private val responseFragment2: (String) -> Unit = { mensaje ->
        txtMensaje.text = "${txtMensaje.text}\nFragment 2 dice: $mensaje"
    }
}
