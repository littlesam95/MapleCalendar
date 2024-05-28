package com.bodan.maplecalendar.presentation.views.calendar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentCalendarBinding
import com.bodan.maplecalendar.presentation.config.BaseFragment
import com.bodan.maplecalendar.presentation.views.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var calendarListAdapter: CalendarListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = calendarListAdapter

        collectLatestFlow(viewModel.calendarUiEvent) { handleUiEvent(it) }
    }

    private fun initListAdapter() {
        calendarListAdapter = CalendarListAdapter(viewModel)
    }

    private fun initRecyclerView() {
        binding.rvCalendar.setHasFixedSize(false)
    }

    private fun handleUiEvent(event: CalendarUiEvent) = when (event) {
        is CalendarUiEvent.BadRequest -> {
            showSnackBar(R.string.message_bad_request)
        }

        is CalendarUiEvent.UnauthorizedStatus -> {
            showSnackBar(R.string.message_network_error)
        }

        is CalendarUiEvent.Forbidden -> {
            showSnackBar(R.string.message_forbidden)
        }

        is CalendarUiEvent.TooManyRequests -> {
            showSnackBar(R.string.message_too_many_requests)
        }

        is CalendarUiEvent.InternalServerError -> {
            showSnackBar(R.string.message_network_error)
        }

        is CalendarUiEvent.GetEventsOfDate -> {
            findNavController().navigateSafely(R.id.action_calendar_to_day_event)
        }

        is CalendarUiEvent.SetDarkMode -> {
            setDarkMode()
        }

        else -> {}
    }
}