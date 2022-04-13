package com.example.bloodpair.activities.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import bloodpair.databinding.FragmentConfirmDeliveryBinding
import com.example.bloodpair.activities.home.HomeViewModel

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