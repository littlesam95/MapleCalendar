package com.bodan.maplecalendar.presentation.views.lobby

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.databinding.FragmentCustomCalendarBinding
import com.bodan.maplecalendar.presentation.views.MainViewModel
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.getDaysOfMonth

class CustomCalendarFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentCustomCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomCalendarBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        arguments?.let { argument ->
            val year = argument.getLong("year").toInt()
            val month = argument.getLong("month").toInt()
            val text = "${year}년 ${month}월"
            binding.tvDateInfoCustomCalendar.text = text
            binding.calendarViewCustomCalendar.initCalendarView(
                year,
                month,
                getDaysOfMonth(year, month),
                viewModel
            )
        }
    }

    companion object {

        fun newInstance(itemId: Long) = CustomCalendarFragment().apply {
            arguments = Bundle().apply {
                putLong("year", itemId / 100L)
                putLong("month", itemId % 100L)
            }
        }
    }
}