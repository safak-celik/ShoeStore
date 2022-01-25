package com.udacity.shoestore.store

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.StoreFragmentBinding
import com.udacity.shoestore.models.Shoe

class StoreFragment : Fragment() {

    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: StoreFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.store_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)

        // ViewModel Instance
        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)

        binding.floatingDetail.setOnClickListener {
            fromStoreFragmentToDetailFragment()
        }


        return binding.root
    }

    private fun fromStoreFragmentToDetailFragment() {
        findNavController().navigate(StoreFragmentDirections.actionStoreFragmentToDetailFragment())
    }

    // connect Actionbar Item with Navigation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.store_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }
}