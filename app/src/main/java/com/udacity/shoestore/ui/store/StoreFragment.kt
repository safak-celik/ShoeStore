package com.udacity.shoestore.ui.store

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.databinding.StoreFragmentBinding

class StoreFragment : Fragment() {

    private lateinit var binding: StoreFragmentBinding
    private val viewModel: StoreViewModel by activityViewModels()

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

        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        insertView()


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

    private fun insertView() {
        // Do not show First item
        if (viewModel.shoes.value?.size!! > 1) {
            val shoeItemLayoutBinding =
                ShoeItemLayoutBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.linearLayout,
                    false
                )
            shoeItemLayoutBinding.apply {
                // Get Last Element from List
                shoeName.text = viewModel.shoes.value?.last()?.name
                shoeCompany.text = viewModel.shoes.value?.last()?.company
                shoeSize.text = viewModel.shoes.value?.last()?.size
                shoeDescription.text = viewModel.shoes.value?.last()?.description
            }
            binding.linearLayout.addView(shoeItemLayoutBinding.root)
        }
    }
}