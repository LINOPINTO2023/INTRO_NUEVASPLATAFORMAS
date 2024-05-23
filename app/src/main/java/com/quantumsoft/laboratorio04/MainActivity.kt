package com.quantumsoft.laboratorio04

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var txtMensaje:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtMensaje=findViewById<TextView>(R.id.txtMensaje)
        val blankFragment=BlankFragment.newInstance(response)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout, blankFragment)
        }
    }


    val response:(String)->Unit={mensaje->
        txtMensaje.text=mensaje

    }

}