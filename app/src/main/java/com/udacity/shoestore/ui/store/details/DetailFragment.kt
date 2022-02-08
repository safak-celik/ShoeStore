package com.udacity.shoestore.ui.store.details

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import com.udacity.shoestore.ui.store.model.ShoeEntity
import com.udacity.shoestore.ui.store.StoreViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding
    private val viewModel: StoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        onClickListeners()

        return binding.root
    }


    private fun addShoe() {
        val newShoe = ShoeEntity(
            name = binding.shoeNameEditText.text.toString(),
            company = binding.companyNameEditText.text.toString(),
            size = binding.shoeSizeEditText.text.toString(),
            description = binding.shoeDescriptionEditText.text.toString(),
            counter = viewModel.counter.value
        )

        viewModel.addShoe(newShoe)
        findNavController().navigateUp()
    }

    private fun cancel() {
        findNavController().navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.details_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun onClickListeners() {
        binding.saveButton.setOnClickListener {
            addShoe()
        }

        binding.cancelButton.setOnClickListener {
            cancel()
        }
    }
}