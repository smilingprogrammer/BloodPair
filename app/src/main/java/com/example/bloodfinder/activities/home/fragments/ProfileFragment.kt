package com.example.bloodfinder.activities.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.home.HomeViewModel
import com.example.bloodfinder.databinding.FragmentHomeBinding
import com.example.bloodfinder.databinding.FragmentProfileBinding
import com.example.bloodfinder.network.login.LoginResponse

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentProfileBinding.inflate(
            LayoutInflater.from(container?.context)
        )

        setProfileData(binding, viewModel.userDetails)

        return binding.root
    }

    fun setProfileData(binding: FragmentProfileBinding, userDetails: LoginResponse){
        binding.apply {
            tvLabName.text = userDetails.user.fullname
            tvFullname.text = userDetails.user.fullname
            tvEmail.text = userDetails.user.email
            tvPhone.text = userDetails.user.phone
            tvAddress.text = userDetails.user.address
        }
    }
}