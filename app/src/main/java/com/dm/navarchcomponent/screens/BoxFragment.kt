package com.dm.navarchcomponent.screens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dm.navarchcomponent.R
import com.dm.navarchcomponent.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding

    private  val args: BoxFragmentArgs by navArgs()

    companion object {
        const val ARG_COLOR = "ARG_COLOR"

        const val ARG_COLOR_NAME = "colorName"
        //const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE" // по этому ключу получим результат
        const val EXTRA_RANDOM_NUMBER =
            "EXTRA_RANDOM_NUMBER" // под этим ключем будет значение number
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        var color = args.color

        binding.root.setBackgroundColor(color)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.generateNumberButton.setOnClickListener {
            var number = Random.nextInt(100)
            // send the result with navigationController
            findNavController().previousBackStackEntry?.savedStateHandle?.set(EXTRA_RANDOM_NUMBER, number)

            //FragmentResultAPI
//            parentFragmentManager.setFragmentResult(
//                REQUEST_CODE,
//                bundleOf(EXTRA_RANDOM_NUMBER to number)
//            )
            findNavController().popBackStack()
        }
        binding.openSecretButton.setOnClickListener {
            //findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
            findNavController().navigate(BoxFragmentDirections.actionBoxFragmentToSecretFragment())
        }
    }
}