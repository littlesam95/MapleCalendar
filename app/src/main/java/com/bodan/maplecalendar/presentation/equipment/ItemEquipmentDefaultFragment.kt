package com.bodan.maplecalendar.presentation.equipment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentItemEquipmentDefaultBinding
import com.bodan.maplecalendar.presentation.BaseDialogFragment
import com.bodan.maplecalendar.presentation.CharacterViewModel

class ItemEquipmentDefaultFragment : BaseDialogFragment<FragmentItemEquipmentDefaultBinding>(R.layout.fragment_item_equipment_default) {

    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
    }
}