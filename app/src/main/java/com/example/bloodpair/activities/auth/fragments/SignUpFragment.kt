package com.example.bloodpair.activities.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import bloodpair.databinding.FragmentSignUpBinding
import com.example.bloodpair.activities.auth.AuthViewModel
import com.example.bloodpair.network.registration.NewUser

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(LayoutInflater.from(container?.context))
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        viewModel.registerUserResponse.observe(viewLifecycleOwner, Observer {res->
            Toast.makeText(context, "User ${res} added to database", Toast.LENGTH_SHORT)
                .show()
        })
        viewModel.apiError.observe(viewLifecycleOwner, Observer {err->
            Toast.makeText(context, err, Toast.LENGTH_SHORT)
                .show()
        })

        binding.signupButton.setOnClickListener{
            if(!binding.etvHospitalName.text.toString().isEmpty()) {
                addUser()
            }else{
                Toast.makeText(context, "Input is empty", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        // Return binding root
        return binding.root
    }

    private fun addUser(){
        binding.apply {
            val fullName = etvHospitalName.text.toString()
            val email = etvEmail.text.toString()
            val password = etvPassword.text.toString()
            val passwordConfirm = etvPasswordConfirm.text.toString()
            val phone = etvPhone.text.toString().toLong()
            val address = etvAddress.text.toString()
            val city = etvCity.text.toString()
            val state = etvState.text.toString()

            val newUser = NewUser(fullName, email, password, passwordConfirm, phone, address, city, state)

            viewModel.registerUser(newUser)
        }
    }
}