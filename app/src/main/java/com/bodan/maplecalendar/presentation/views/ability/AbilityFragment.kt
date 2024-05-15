package com.bodan.maplecalendar.presentation.views.ability

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentAbilityBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.utils.PowerFormatConverter.convertCommaFormat
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.bodan.maplecalendar.presentation.views.character.CharacterUiEvent
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AbilityFragment : BaseDialogFragment<FragmentAbilityBinding>(R.layout.fragment_ability) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var abilityAdapter: AbilityAdapter

    override fun onResume() {
        super.onResume()

        requireContext().dialogFragmentResize(this, 0.9F, 0.6F)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initAbilityPreset()
        initTabLayout()

        binding.vm = viewModel
        binding.tvRemainPointValueAbility.text =
            convertCommaFormat(viewModel.characterAbility.value?.remainFame)

        isCancelable = false

        lifecycleScope.launch {
            viewModel.characterUiEvent.collectLatest { uiEvent ->
                if (uiEvent == CharacterUiEvent.CloseAbility) dismiss()
            }
        }
    }

    private fun initAdapter() {
        abilityAdapter = AbilityAdapter(requireActivity())
    }

    private fun initAbilityPreset() {
        with(binding.vpAbility) {
            adapter = abilityAdapter
            setCurrentItem(AbilityAdapter.START_POSITION, false)
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tlAbility, binding.vpAbility) { tab, position ->
            tab.text = "Preset ${position + 1}"
        }.attach()
        for (i in 0 until 3) {
            val tabs = binding.tlAbility.getChildAt(0) as ViewGroup
            for (tab in tabs.children) {
                val lp = tab.layoutParams as LinearLayout.LayoutParams
                lp.marginEnd = 16
                tab.layoutParams = lp
                binding.tlAbility.requestLayout()
            }
        }
    }
}