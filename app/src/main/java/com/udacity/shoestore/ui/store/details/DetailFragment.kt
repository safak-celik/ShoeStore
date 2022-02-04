package com.udacity.shoestore.ui.store.details

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.ui.store.ShoeEntity
import com.udacity.shoestore.ui.store.StoreViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding
    private val viewModel: StoreViewModel by activityViewModels()

    private var launchSomeActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                binding.previewImage.setImageURI(data?.data)
            }
        }

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
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        binding.cancelButton.setOnClickListener {
            cancel()
        }
        binding.saveButton.setOnClickListener {
            addShoe()
        }

        binding.chooseImageButton.setOnClickListener {
            startGallery()
        }
        return binding.root
    }


    private fun startGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK)
        galleryIntent.type = "image/*"
        launchSomeActivity.launch(galleryIntent)
    }


    private fun addShoe() {
        val newShoe = ShoeEntity(
            name = binding.shoeNameEditText.text.toString(),
            company = binding.companyNameEditText.text.toString(),
            size = binding.shoeSizeEditText.text.toString(),
            description = binding.shoeDescriptionEditText.text.toString(),
            image = binding.previewImage
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
}