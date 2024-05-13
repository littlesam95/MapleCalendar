package com.bodan.maplecalendar.presentation.views.hyperstat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentHyperStatBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import com.bodan.maplecalendar.presentation.views.character.CharacterUiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HyperStatFragment :
    BaseDialogFragment<FragmentHyperStatBinding>(R.layout.fragment_hyper_stat) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var hyperStatAdapter: HyperStatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initHyperStatPreset()

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
        }
    }
}