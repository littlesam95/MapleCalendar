package com.bodan.maplecalendar.presentation.views.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentItemEquipmentDetailBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel

class ItemEquipmentDetailFragment : BaseDialogFragment<FragmentItemEquipmentDetailBinding>(R.layout.fragment_item_equipment_detail) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var itemEquipmentDetailOptionListAdapter: ItemEquipmentDetailOptionListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = itemEquipmentDetailOptionListAdapter
    }

    private fun initListAdapter() {
        itemEquipmentDetailOptionListAdapter = ItemEquipmentDetailOptionListAdapter()
    }

    private fun initRecyclerView() {
        binding.rvOptionItemEquipmentDetail.setHasFixedSize(false)
    }
}