package com.udacity.shoestore.store.details

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DetailsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.details_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)

        binding.cancelButton.setOnClickListener {
            fromDetailsFragmentToStoreFragment()
        }
        binding.saveButton.setOnClickListener {
            fromDetailsFragmentToStoreFragment()
            // TODO MORE LATER
        }

        return binding.root
    }

    private fun fromDetailsFragmentToStoreFragment() {
        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToStoreFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.details_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // connect Actionbar Item with Navigation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}