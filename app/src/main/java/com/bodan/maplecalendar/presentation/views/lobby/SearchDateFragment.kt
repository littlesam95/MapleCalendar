package com.bodan.maplecalendar.presentation.views.lobby

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentSearchDateBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchDateFragment :
    BaseDialogFragment<FragmentSearchDateBinding>(R.layout.fragment_search_date) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var customCalendarAdapter: CustomCalendarAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.lobbyUiEvent.collectLatest { uiEvent ->
                if (uiEvent == LobbyUiEvent.CloseSearchDate) dismiss()
            }
        }
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            viewModel.getSearchDate().collectLatest { searchDate ->
                searchDate?.let {
                    customCalendarAdapter = CustomCalendarAdapter(requireActivity(), searchDate)
                    initCustomCalendar()
                }
            }
        }
    }

    private fun initCustomCalendar() {
        with(binding.vpSearchDate) {
            adapter = customCalendarAdapter
            setCurrentItem(CustomCalendarAdapter.START_POSITION, false)
        }
    }
}