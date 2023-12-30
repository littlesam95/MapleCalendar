package com.bodan.maplecalendar.presentation.calendar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentDayEventBinding
import com.bodan.maplecalendar.presentation.BaseDialogFragment
import com.bodan.maplecalendar.presentation.MainViewModel
import com.bodan.maplecalendar.presentation.lobby.EventListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DayEventFragment : BaseDialogFragment<FragmentDayEventBinding>(R.layout.fragment_day_event) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var eventListAdapter: EventListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = eventListAdapter
        isCancelable = false

        lifecycleScope.launch {
            viewModel.calendarUiEvent.collectLatest { uiEvent ->
                if (uiEvent == CalendarUiEvent.CloseEventsOfDate) dismiss()
                if (uiEvent == CalendarUiEvent.StartEventUrl) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.eventUrl.value)))
                }
            }
        }
    }

    private fun initListAdapter() {
        eventListAdapter = EventListAdapter(viewModel)
    }

    private fun initRecyclerView() {
        binding.rvDayEvent.setHasFixedSize(false)
    }
}