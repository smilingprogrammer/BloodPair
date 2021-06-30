package com.example.bloodfinder.activities.auth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.splashScreens.MainActivity
import com.example.bloodfinder.databinding.FragmentSignInBinding
import com.example.bloodfinder.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSignUpBinding.inflate(LayoutInflater.from(container?.context))

        binding.apply {

        }

        // Return binding root
        return binding.root
    }
}