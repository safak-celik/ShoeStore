package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)
        onClickListeners()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.login_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun fromLoginFragmentToWelcomeFragment() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

    private fun onClickListeners() {
        binding.btnCheckLogin.setOnClickListener {
            fromLoginFragmentToWelcomeFragment()
        }
        binding.btnNewAccount.setOnClickListener {
            fromLoginFragmentToWelcomeFragment()
        }
    }
}

