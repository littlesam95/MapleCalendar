package com.bodan.maplecalendar.presentation.calendar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentCalendarBinding
import com.bodan.maplecalendar.presentation.BaseFragment
import com.bodan.maplecalendar.presentation.MainViewModel

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        collectLatestFlow(viewModel.calendarUiEvent) { handleUiEvent(it) }
    }

    private fun handleUiEvent(event: CalendarUiEvent) = when (event) {
        is CalendarUiEvent.NetworkErrorEvent -> {
            showSnackBar(R.string.message_network_error)
        }
    }
}