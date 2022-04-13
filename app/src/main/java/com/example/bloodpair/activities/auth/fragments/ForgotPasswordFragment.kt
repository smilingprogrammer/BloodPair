package com.example.bloodpair.activities.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bloodpair.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentForgotPasswordBinding.inflate(LayoutInflater.from(container?.context))

        binding.apply {

        }

        // Return binding root
        return binding.root
    }
}