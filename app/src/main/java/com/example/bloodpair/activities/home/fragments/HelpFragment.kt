package com.example.bloodpair.activities.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import bloodpair.databinding.FragmentHelpBinding
import com.example.bloodpair.activities.home.HomeViewModel

class HelpFragment : Fragment() {

    private lateinit var binding: FragmentHelpBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHelpBinding.inflate(
            LayoutInflater.from(container?.context)
        )

        return binding.root
    }
}