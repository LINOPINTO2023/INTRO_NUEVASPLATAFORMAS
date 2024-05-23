package com.quantumsoft.laboratorio04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_blank, container, false)
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val btnEnviarMensaje = view.findViewById<Button>(R.id.btnEnviarMensaje)
        val edtMensaje = view.findViewById<EditText>(R.id.edtMensaje)
        btnEnviarMensaje.setOnClickListener{
            val mensaje=edtMensaje.text.toString()
            clickBtnEnviarMensaje(mensaje)
        }
        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        //private const val ARG_PARAM1 = "param1"
        //private const val ARG_PARAM2 = "param2"

        // TODO: Rename and change types and number of parameters

        /**fun newInstance(param1: String?, param2: String?): BlankFragment {
            val fragment = BlankFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }*/
        private lateinit var clickBtnEnviarMensaje: (String) -> Unit

        fun newInstance(clickBtnEnviarMensaje:(String)->Unit):BlankFragment{
            val blankFragment=BlankFragment()
            this.clickBtnEnviarMensaje=clickBtnEnviarMensaje

            return blankFragment
        }
    }
}
