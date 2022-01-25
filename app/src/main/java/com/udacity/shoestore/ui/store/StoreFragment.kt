package com.udacity.shoestore.ui.store

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.StoreFragmentBinding

class StoreFragment : Fragment() {

    private lateinit var binding: StoreFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.store_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)


        binding.floatingDetail.setOnClickListener {
            fromStoreFragmentToDetailFragment()
        }
        getViews()

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

    private fun getViews() {
        val storeFragmentArgs by navArgs<StoreFragmentArgs>()
        binding.item.apply {
            shoeName.text = storeFragmentArgs.name
            shoeCompany.text = storeFragmentArgs.company
            shoeSize.text = storeFragmentArgs.size.toString()
            shoeDescription.text = storeFragmentArgs.description
        }
    }
}