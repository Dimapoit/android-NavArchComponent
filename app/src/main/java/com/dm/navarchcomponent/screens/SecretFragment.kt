package com.dm.navarchcomponent.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dm.navarchcomponent.R
import com.dm.navarchcomponent.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {

    private lateinit var binding: FragmentSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSecretBinding.bind(view)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.closeBoxButton.setOnClickListener {
            //Нижняя кнопка
            findNavController().popBackStack(R.id.rootFragment, false)
            //Верхняя кнопка
            findNavController().navigateUp()
        }


    }
}