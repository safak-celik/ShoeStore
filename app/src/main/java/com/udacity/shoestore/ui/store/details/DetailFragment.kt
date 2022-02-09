package com.udacity.shoestore.ui.store.details

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.ui.store.StoreViewModel
import com.udacity.shoestore.ui.store.model.ShoeEntity

class DetailFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding
    private val viewModel: StoreViewModel by activityViewModels()

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
        // Bind empty shoe, entered values will be stored inside
        binding.shoeEntity = ShoeEntity("", "", "", "")

        setHasOptionsMenu(true)
        onClickListeners()

        return binding.root
    }


    private fun addShoe() {
        binding.shoeEntity = ShoeEntity(
            name = binding.shoeEntity!!.name,
            company = binding.shoeEntity!!.company,
            size = binding.shoeEntity!!.size,
            description = binding.shoeEntity!!.description,
            counter = viewModel.counter.value.toString()
        )
        viewModel.addShoe(binding.shoeEntity!!)
        Log.d("ListOfShoes", "${viewModel.shoeListLiveData.value}")
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