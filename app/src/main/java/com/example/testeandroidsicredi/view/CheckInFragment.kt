package com.example.testeandroidsicredi.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.testeandroidsicredi.R
import com.example.testeandroidsicredi.databinding.FragmentCheckinBinding
import com.example.testeandroidsicredi.databinding.FragmentEventDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckInFragment : Fragment(R.layout.fragment_checkin) {

    private lateinit var binding: FragmentCheckinBinding
    private val args by navArgs<CheckInFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCheckinBinding.bind(view)


    }


}