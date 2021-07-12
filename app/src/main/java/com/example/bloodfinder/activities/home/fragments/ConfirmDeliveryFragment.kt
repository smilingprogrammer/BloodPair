package com.example.bloodfinder.activities.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.home.HomeViewModel
import com.example.bloodfinder.databinding.FragmentConfirmDeliveryBinding
import com.example.bloodfinder.databinding.FragmentHomeBinding
import com.example.bloodfinder.databinding.FragmentProfileBinding

class ConfirmDeliveryFragment : Fragment() {

    private lateinit var binding: FragmentConfirmDeliveryBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmDeliveryBinding.inflate(
            LayoutInflater.from(container?.context)
        )

        return binding.root
    }
}