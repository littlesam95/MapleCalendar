package com.bodan.maplecalendar.presentation.views.hyperstat

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentHyperStatBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.bodan.maplecalendar.presentation.views.character.CharacterUiEvent
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HyperStatFragment :
    BaseDialogFragment<FragmentHyperStatBinding>(R.layout.fragment_hyper_stat) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var hyperStatAdapter: HyperStatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initHyperStatPreset()
        initTabLayout()

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.characterUiEvent.collectLatest { uiEvent ->
                if (uiEvent == CharacterUiEvent.CloseHyperStat) dismiss()
            }
        }
    }

    private fun initAdapter() {
        hyperStatAdapter = HyperStatAdapter(requireActivity())
    }

    private fun initHyperStatPreset() {
        with(binding.vpHyperStat) {
            adapter = hyperStatAdapter
            setCurrentItem(HyperStatAdapter.START_POSITION, false)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    viewModel.setCharacterHyperStatRemainPoint(position)
                }
            })
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tlHyperStat, binding.vpHyperStat) { tab, position ->
            tab.text = "Preset ${position + 1}"
        }.attach()
        for (i in 0 until 3) {
            val tabs = binding.tlHyperStat.getChildAt(0) as ViewGroup
            for (tab in tabs.children) {
                val lp = tab.layoutParams as LinearLayout.LayoutParams
                lp.marginEnd = 16
                tab.layoutParams = lp
                binding.tlHyperStat.requestLayout()
            }
        }
    }
}