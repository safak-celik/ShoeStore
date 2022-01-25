package com.udacity.shoestore.ui.store.details

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.ui.store.StoreViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding

    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.details_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        binding.storeViewModel = viewModel
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        binding.cancelButton.setOnClickListener {
            fromDetailsFragmentToStoreFragment()
        }
        binding.saveButton.setOnClickListener {
            fromDetailsFragmentToStoreFragmentWithData()
        }

        return binding.root
    }

    private fun fromDetailsFragmentToStoreFragmentWithData() {
        NavHostFragment.findNavController(this).navigate(
            DetailFragmentDirections.actionDetailFragmentToStoreFragment(
                // Send Data to StoreFragment
                name = binding.shoeNameEditText.text.toString(),
                size = binding.shoeSizeEditText.text.toString().toInt(),
                company = binding.companyNameEditText.text.toString(),
                description = binding.shoeDescriptionEditText.text.toString()
            )
        )
    }

    private fun fromDetailsFragmentToStoreFragment() {
        NavHostFragment.findNavController(this).navigate(
            DetailFragmentDirections.actionDetailFragmentToStoreFragment(
                // Empty Data
                name = "",
                size = 0,
                company = "",
                description = ""
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.details_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }
}