package com.example.lab04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val btnEnviarMensaje = view.findViewById<Button>(R.id.btnEnviarMensaje)
        val editMensaje = view.findViewById<EditText>(R.id.edtMensaje)

        btnEnviarMensaje.setOnClickListener {
            val mensaje = editMensaje.text.toString()
            clickBtnEnviarMensaje(mensaje)
        }
        return view
    }

    companion object {
        private lateinit var clickBtnEnviarMensaje: (String) -> Unit

        @JvmStatic
        fun newInstance(clickBtnEnviarMensaje: (String) -> Unit): SecondFragment {
            val secondFragment = SecondFragment()
            this.clickBtnEnviarMensaje = clickBtnEnviarMensaje
            return secondFragment
        }
    }
}
