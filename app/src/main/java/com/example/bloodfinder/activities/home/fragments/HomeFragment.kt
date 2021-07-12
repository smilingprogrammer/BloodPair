package com.example.bloodfinder.activities.home.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.home.HomeViewModel
import com.example.bloodfinder.databinding.FragmentHomeBinding
import com.example.bloodfinder.databinding.FragmentProfileBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(
            LayoutInflater.from(container?.context)
        )
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        return binding.root
    }

}