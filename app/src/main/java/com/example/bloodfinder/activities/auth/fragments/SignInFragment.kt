package com.example.bloodfinder.activities.auth.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.splashScreens.MainActivity
import com.example.bloodfinder.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSignInBinding.inflate(LayoutInflater.from(container?.context))

        binding.apply {
            // Sign in when sign in botton is clicked
            btnSignin.setOnClickListener{v ->
                val intent = Intent(v.context,MainActivity::class.java)
                v.context.startActivity(intent)
            }
            // Navigate to sign up fragment when sign up text is clicked
            txvSignUp.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
                )
            )
            // Navigate to forgot if forgot password textview is clicked
            txvForgotPassword.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    SignInFragmentDirections.actionSignInFragmentToForgotPasswordFragment()
                )
            )
        }

        // Set Toolbar title
        val toolbar: Toolbar = requireActivity().findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.setTitle("Sign In")

        // Return binding root
        return binding.root
    }
}