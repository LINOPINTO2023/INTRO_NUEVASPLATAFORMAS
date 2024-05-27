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
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa y muestra el fragmento de inicio (HomeFragment)
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, homeFragment)
            .commit()


        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mRegister -> {
                    val fragment = createRegisterFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
                }
                R.id.mHome -> {
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
                }
            }
            true
        }
        //txtMensaje = findViewById<TextView>(R.id.txtMessage)

        // Se instancia el fragment con parametro a la funcion lambda del Activity
        //val blankFragment = FragmentMessage.newInstance(response)

//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace(R.id.frameLayout, blankFragment)
//        }
    }

    // Función para crear y configurar el RegisterFragment
    private fun createRegisterFragment(): RegisterFragment {
        val fragment = RegisterFragment()
        fragment.setOnDataPassListener { formData ->
            val homeFragment = HomeFragment()
            val bundle = Bundle().apply {
                putParcelable("formData", formData)
            }
            homeFragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, homeFragment)
                .addToBackStack(null)
                .commit()
        }
        return fragment
    }
    // Crea una funcion lambda que sera parametro del fragment
//    val response: (String) -> Unit = { mensaje ->
//        //txtMensaje.text = mensaje;
//    }
}