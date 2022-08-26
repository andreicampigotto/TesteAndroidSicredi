package com.example.testeandroidsicredi.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.testeandroidsicredi.R
import com.example.testeandroidsicredi.databinding.FragmentCheckinBinding
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.viewModel.EventViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckInFragment : Fragment(R.layout.fragment_checkin) {

    private lateinit var binding: FragmentCheckinBinding
    private val args by navArgs<CheckInFragmentArgs>()
    private lateinit var viewModel: EventViewModel

    private val observerCheckIn = Observer<String> {
        viewModel.checkIn
    }

    private val observerEvent = Observer<Event> {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCheckinBinding.bind(view)

        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
        viewModel.checkIn.observe(viewLifecycleOwner, observerCheckIn)
        viewModel.event.observe(viewLifecycleOwner, observerEvent)

        checkIn()
        clearFields()
    }


    private fun clearFields() {
        binding.tfNome.editText?.setText("")
        binding.tfEmail.editText?.setText("")
    }

    private fun checkIn() {
        val id = args.eventId
        val name = binding.tfNome.editText
        val email = binding.tfEmail.editText

        if (name!!.text.isNotEmpty() && email!!.text.isNotEmpty()) {
            viewModel.setCheckIn(id = id, name = name.toString(), email = email.toString())
        }
        binding.mbCheckIn.setOnClickListener {
            Snackbar.make(
                it,
                "Por favor entre em contato via e-mail avisando para corrigirmos o quanto antes.",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}