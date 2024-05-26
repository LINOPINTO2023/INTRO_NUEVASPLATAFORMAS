package com.example.fragments

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var txtMensaje: TextView;
    private  lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // supportFragmentManager.beginTransaction().add(R.id.frameLayout, )

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mRegister -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, RegisterFragment()).commit()
            }
            true
        }
        //txtMensaje = findViewById<TextView>(R.id.txtMessage)

        // Se instancia el fragment con parametro a la funcion lambda del Activity
        //val blankFragment = FragmentMessage.newInstance(response)

        supportFragmentManager.commit {
            //setReorderingAllowed(true)
            //replace(R.id.frameLayout, blankFragment)
        }
    }

    // Crea una funcion lambda que sera parametro del fragment
    val response: (String) -> Unit = { mensaje ->
        //txtMensaje.text = mensaje;
    }
}