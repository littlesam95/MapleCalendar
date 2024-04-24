package com.bodan.maplecalendar.presentation.lobby

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentSearchDateBinding
import com.bodan.maplecalendar.presentation.BaseDialogFragment
import com.bodan.maplecalendar.presentation.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchDateFragment :
    BaseDialogFragment<FragmentSearchDateBinding>(R.layout.fragment_search_date) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var customCalendarAdapter: CustomCalendarAdapter

    override fun onResume() {
        super.onResume()

        requireContext().dialogFragmentResize(this, 0.8F, 0.5F)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initCustomCalendar()

        binding.vm = viewModel

        lifecycleScope.launch {
            viewModel.lobbyUiEvent.collectLatest { uiEvent ->
                if (uiEvent == LobbyUiEvent.CloseSearchDate) dismiss()
            }
        }
    }

    private fun initAdapter() {
        customCalendarAdapter = CustomCalendarAdapter(requireActivity())
    }

    private fun initCustomCalendar() {
        with(binding.vpSearchDate) {
            adapter = customCalendarAdapter
            setCurrentItem(CustomCalendarAdapter.START_POSITION, false)
        }
    }

    private fun Context.dialogFragmentResize(
        dialogFragment: DialogFragment,
        width: Float,
        height: Float
    ) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val window = dialogFragment.dialog?.window
        if (Build.VERSION.SDK_INT < 30) {
            val displayWidth = resources.displayMetrics.widthPixels
            val displayHeight = resources.displayMetrics.heightPixels

            val x = (displayWidth * width).toInt()
            val y = (displayHeight * height).toInt()

            window?.setLayout(x, y)
        } else {
            val rect = windowManager.currentWindowMetrics.bounds

            val x = (rect.width() * width).toInt()
            val y = (rect.height() * height).toInt()

            window?.setLayout(x, y)
        }
    }
}