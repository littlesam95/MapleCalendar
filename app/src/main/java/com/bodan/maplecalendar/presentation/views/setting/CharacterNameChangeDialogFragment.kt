package com.bodan.maplecalendar.presentation.views.setting

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentCharacterNameChangeDialogBinding
import com.bodan.maplecalendar.presentation.views.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterNameChangeDialogFragment : BottomSheetDialogFragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentCharacterNameChangeDialogBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate<FragmentCharacterNameChangeDialogBinding>(
            inflater,
            R.layout.fragment_character_name_change_dialog,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.settingUiEvent.collectLatest { uiEvent ->
                if (uiEvent == SettingUiEvent.CloseChangeCharacterName) dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}