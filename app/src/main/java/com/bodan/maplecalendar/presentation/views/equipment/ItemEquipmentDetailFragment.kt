package com.bodan.maplecalendar.presentation.views.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentItemEquipmentDetailBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class ItemEquipmentDetailFragment :
    BaseDialogFragment<FragmentItemEquipmentDetailBinding>(R.layout.fragment_item_equipment_detail) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var itemEquipmentDetailOptionListAdapter: ItemEquipmentDetailOptionListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = itemEquipmentDetailOptionListAdapter

        initStarforce()

        lifecycleScope.launch {
            viewModel.equipmentUiEvent.collectLatest { uiEvent ->
                if (uiEvent == EquipmentUiEvent.CloseItemEquipmentDetail) dismiss()
            }
        }
    }

    private fun initListAdapter() {
        itemEquipmentDetailOptionListAdapter = ItemEquipmentDetailOptionListAdapter()
    }

    private fun initRecyclerView() {
        binding.rvOptionItemEquipmentDetail.setHasFixedSize(false)
    }

    private fun initStarforce() {
        viewModel.characterLastItemEquipment.value?.let { itemEquipment ->
            if (itemEquipment.maxStarforceValue >= 1) {
                binding.starforceFirstItemEquipmentDetail.initStarforceView(
                    itemEquipment.itemStarforce.toInt(),
                    itemEquipment.maxStarforceValue,
                    itemEquipment.isStarforceScrollUsed
                )
            }
            if (itemEquipment.maxStarforceValue >= 16) {
                binding.starforceSecondItemEquipmentDetail.initStarforceView(
                    itemEquipment.itemStarforce.toInt(),
                    itemEquipment.maxStarforceValue
                )
            }
        }
    }
}