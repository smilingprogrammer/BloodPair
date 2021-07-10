package com.example.bloodfinder.activities.auth.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.bloodfinder.LoadingDialog
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.auth.AuthViewModel
import com.example.bloodfinder.activities.home.HomeActivity
import com.example.bloodfinder.databinding.FragmentSignInBinding
import com.example.bloodfinder.db.BloodHQRepository
import com.example.bloodfinder.db.entities.UserData
import kotlinx.coroutines.launch
import java.sql.Connection


class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var viewModel: AuthViewModel
    private lateinit var loadingAlert: LoadingDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(LayoutInflater.from(container?.context))
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        // Observe viewModel for user login and move to Home fragment if user logged in successfully
        viewModel.user.observe(viewLifecycleOwner, Observer { user->
            if (user?.user?.fullname != null){
                val intent = Intent(context, HomeActivity::class.java)
                intent.putExtra(HomeActivity.USER_DETAILS, user)
                startActivity(intent)
                loadingAlert.dismissDialog()
            }
        })

        // Get error message if login fails
        viewModel.apiError.observe(viewLifecycleOwner, Observer {err->
            loadingAlert.dismissDialog()
            Toast.makeText(context," Error trying to LogIn: Message: = ${err}", Toast.LENGTH_SHORT)
                .show()
        })

        binding.apply {
            // Sign in when sign in botton is clicked
            btnSignin.setOnClickListener{
                checkNetworkState()
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

        // Return binding root
        return binding.root
    }

    private fun checkNetworkState() {
        val manager = requireActivity().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager
        val networkInfo = manager.activeNetworkInfo
        if(networkInfo != null){
            loadingAlert = LoadingDialog(requireActivity())
            loadingAlert.startDialog()

            if (!binding.email.text!!.isEmpty() && !binding.password.text!!.isEmpty()) loginUser()

        }else{
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.no_internet)
            dialog.setCancelable(true)
            dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.show()
        }

    }

    // Login User function
    private fun loginUser(){
        binding.apply {
            val email = email.text.toString()
            val password = password.text.toString()

            viewModel.loginUser(email, password)
        }
    }
}