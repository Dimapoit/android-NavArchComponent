package com.dm.navarchcomponent.screens

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dm.navarchcomponent.R
import com.dm.navarchcomponent.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRootBinding.bind(requireView())

        binding.openGreenBoxButton.setOnClickListener {
            openBox(Color.GREEN, "Green")
        }
        binding.openYellowBoxButton.setOnClickListener {
            openBox(Color.YELLOW, "Yellow")
        }

        //navigationController
        val liveData = findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Int>(BoxFragment.EXTRA_RANDOM_NUMBER)
        liveData?.observe(viewLifecycleOwner) { randNumber ->
            if (randNumber != null) {
                Toast.makeText(
                    requireContext(),
                    "Generated number: $randNumber",
                    Toast.LENGTH_LONG
                ).show()
                liveData.value = null
            }

        }
        /* parentFragmentManager.setFragmentResultListener(
            BoxFragment.REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(), "Generated number: $number", Toast.LENGTH_LONG).show()
        } */
    }

    private fun openBox(color: Int, colorName: String) {

        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(color, colorName)

        findNavController().navigate(
//            R.id.action_rootFragment_to_boxFragment,
//            bundleOf(
//                BoxFragment.ARG_COLOR to color,
//                BoxFragment.ARG_COLOR_NAME to colorName
//            )
        direction
        )
    }
}