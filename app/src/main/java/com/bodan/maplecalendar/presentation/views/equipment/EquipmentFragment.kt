package com.bodan.maplecalendar.presentation.views.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentEquipmentBinding
import com.bodan.maplecalendar.presentation.config.BaseFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EquipmentFragment : BaseFragment<FragmentEquipmentBinding>(R.layout.fragment_equipment) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var equipmentListAdapter: EquipmentListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = equipmentListAdapter

        collectLatestFlow(viewModel.equipmentUiEvent) { handleUiEvent(it) }
    }

    private fun initListAdapter() {
        equipmentListAdapter = EquipmentListAdapter(viewModel)
    }

    private fun initRecyclerView() {
        binding.rvEquipment.setHasFixedSize(false)
    }

    private fun handleUiEvent(event: EquipmentUiEvent) = when (event) {
        is EquipmentUiEvent.WaitItemEquipmentDetail -> {
            showSnackBar(R.string.text_loading_equipment)
        }

        is EquipmentUiEvent.GetItemEquipmentDetail -> {
            findNavController().navigateSafely(R.id.action_equipment_to_item_equipment_detail)
        }

        is EquipmentUiEvent.GetAndroidDetail -> {
            findNavController().navigateSafely(R.id.action_equipment_to_android_detail)
        }

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

        is EquipmentUiEvent.GetDarkMode -> {
            setDarkMode(event.isDarkMode)
        }

        else -> {}
    }
}