package com.example.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi


//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {

//    private var param1: String? = null
//    private var param2: String? = null

    private var formData: UserDates? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }

        arguments?.let {
            formData = it.getParcelable("formData", UserDates::class.java)
        }
        Log.d("Home", formData?.userName.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val txtFirstName = view.findViewById<TextView>(R.id.edtFirstNameMain)
        val txtLastName = view.findViewById<TextView>(R.id.edtLastNameMain)
        val txtEmail = view.findViewById<TextView>(R.id.edtEmailMain)
        val txtPhone = view.findViewById<TextView>(R.id.edtPhoneMain)
        val txtUserName = view.findViewById<TextView>(R.id.edtUserNameMain)
        val txtPassword = view.findViewById<TextView>(R.id.edtPasswordMain)

        txtFirstName.text = formData?.firstName
        txtLastName.text = formData?.lastName
        txtEmail.text = formData?.email
        txtPhone.text = formData?.phone.toString()
        txtUserName.text = formData?.userName
        txtPassword.text = formData?.password

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}