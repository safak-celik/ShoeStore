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

    // Item Clickable and StackTrace clearing in navigation graph
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(StoreFragmentDirections.actionStoreFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.store_screen)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun insertView() {
        // Observe LiveData
        viewModel.shoeListLiveData.observe(viewLifecycleOwner) { shoesList ->
            shoesList.takeLast(shoesList.size).forEach { shoeEntity ->
                // inflate the layout of ShoeItem
                val shoeItemLayoutBinding =
                    ShoeItemLayoutBinding.inflate(
                        LayoutInflater.from(requireContext()),
                        binding.linearLayout,
                        false
                    )
                // DataBinding
                shoeItemLayoutBinding.apply {
                    // Get Last Element from List
                    shoeName.text = shoeEntity.name
                    shoeCompany.text = shoeEntity.company
                    shoeSize.text = shoeEntity.size
                    shoeDescription.text = shoeEntity.description
                    counter.text = shoeEntity.counter
                }
                // AddElement
                binding.linearLayout.addView(shoeItemLayoutBinding.root)
            }
        }
    }
}