package com.udacity.shoestore.login

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class.
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)

        binding.btnCheckLogin.setOnClickListener {
            fromLoginFragmentToWelcomeFragment()
        }
        binding.btnNewAccount.setOnClickListener {
            fromLoginFragmentToWelcomeFragment()
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.login_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // connect Actionbar Item with Navigation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    private fun fromLoginFragmentToWelcomeFragment() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }

}