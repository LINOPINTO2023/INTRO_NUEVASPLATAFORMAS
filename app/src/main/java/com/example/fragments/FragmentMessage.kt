package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMessage.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMessage : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_message, container, false)

        val view = inflater.inflate(R.layout.fragment_message, container, false)

        val btnSendMessage = view.findViewById<Button>(R.id.btnMessage)
        val edtMessage = view.findViewById<EditText>(R.id.edtMessage)

        // Cuando se presiona el boton obtiene el mensaje como String y se lo
        // pasa a la funcion lambda
        btnSendMessage.setOnClickListener {
            val message = edtMessage.text.toString()
            clickBtnSendMessage(message)
        }
        return view
    }

    companion object {
        private lateinit var clickBtnSendMessage: (String) -> Unit

        // Toma como parametro una funcion lambda para instanciar la del MainActivity
        @JvmStatic
        fun newInstance(clickBtnSendMessage: (String) -> Unit): FragmentMessage {
            val blankFragment = FragmentMessage()
            this.clickBtnSendMessage = clickBtnSendMessage

            return blankFragment
        }
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FragmentMessage().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}