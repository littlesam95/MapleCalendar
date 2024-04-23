package com.bodan.maplecalendar.presentation.lobby

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentCustomCalendarBinding
import com.bodan.maplecalendar.presentation.utils.CalendarUtils.getMonthList
import org.joda.time.DateTime

class CustomCalendarFragment : Fragment() {

    private lateinit var binding: FragmentCustomCalendarBinding
    private var millis: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { argument ->
            millis = argument.getLong("MILLIS")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCustomCalendarBinding.inflate(inflater, container, false)

        binding.millis.text = DateTime(millis).toString("yyyy-MM")
        binding.calendarview.initCalendarView(DateTime(millis), getMonthList(DateTime(millis)))

        return binding.root
    }

    companion object {

        fun newInstance(millis: Long) = CustomCalendarFragment().apply {
            arguments = Bundle().apply {
                putLong("MILLIS", millis)
            }
        }
    }
}