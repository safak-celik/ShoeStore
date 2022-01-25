package com.udacity.shoestore.ui.instruction

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding


class InstructionFragment : Fragment() {

    private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instruction_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)

        binding.btnEnterShop.setOnClickListener {
            fromInstructionFragmentToStoreFragment()
        }

        return binding.root
    }

    private fun fromInstructionFragmentToStoreFragment() {
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToStoreFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            getString(R.string.instruction_screen)
    }

    // connect Actionbar Item with Navigation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}