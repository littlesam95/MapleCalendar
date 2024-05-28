package com.bodan.maplecalendar.presentation.views.calendar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentDayEventBinding
import com.bodan.maplecalendar.presentation.config.BaseDialogFragment
import com.bodan.maplecalendar.presentation.views.MainViewModel
import com.bodan.maplecalendar.presentation.views.lobby.EventListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DayEventFragment : BaseDialogFragment<FragmentDayEventBinding>(R.layout.fragment_day_event) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var eventListAdapter: EventListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = eventListAdapter

        lifecycleScope.launch {
            viewModel.calendarUiEvent.collectLatest { uiEvent ->
                when (uiEvent) {
                    is CalendarUiEvent.StartEventUrl -> getEventUrl()

                    is CalendarUiEvent.CloseEventsOfDate -> dismiss()

                    else -> {}
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

    private fun getEventUrl() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.eventUrl.value))
        startActivity(intent)
    }
}