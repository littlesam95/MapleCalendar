package com.bodan.maplecalendar.presentation.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentEquipmentBinding
import com.bodan.maplecalendar.presentation.BaseFragment
import com.bodan.maplecalendar.presentation.CharacterViewModel

class EquipmentFragment : BaseFragment<FragmentEquipmentBinding>(R.layout.fragment_equipment) {

    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        collectLatestFlow(viewModel.equipmentUiEvent) { handleUiEvent(it) }
    }

    private fun handleUiEvent(event: EquipmentUiEvent) = when (event) {
        is EquipmentUiEvent.BadRequest -> {
            showSnackBar(R.string.message_bad_request)
        }

        is EquipmentUiEvent.UnauthorizedStatus -> {
            showSnackBar(R.string.message_network_error)
        }

        is EquipmentUiEvent.Forbidden -> {
            showSnackBar(R.string.message_forbidden)
        }

        is EquipmentUiEvent.TooManyRequests -> {
            showSnackBar(R.string.message_too_many_requests)
        }

        is EquipmentUiEvent.InternalServerError -> {
            showSnackBar(R.string.message_network_error)
        }

        is EquipmentUiEvent.SetDarkMode -> {
            setDarkMode()
        }
    }
}