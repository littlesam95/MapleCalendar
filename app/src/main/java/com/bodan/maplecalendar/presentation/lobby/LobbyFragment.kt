package com.bodan.maplecalendar.presentation.lobby

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentLobbyBinding
import com.bodan.maplecalendar.presentation.BaseFragment
import com.bodan.maplecalendar.presentation.MainViewModel

class LobbyFragment : BaseFragment<FragmentLobbyBinding>(R.layout.fragment_lobby) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var eventListAdapter: EventListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.listAdapter = eventListAdapter

        setSwipeRefresh()

        collectLatestFlow(viewModel.lobbyUiEvent) { handleUiEvent(it) }
    }

    private fun initListAdapter() {
        eventListAdapter = EventListAdapter(viewModel)
    }

    private fun initRecyclerView() {
        binding.rvLobby.setHasFixedSize(false)
    }

    private fun setSwipeRefresh() {
        with(binding.fragmentLobby) {
            setOnRefreshListener {
                viewModel.initState()
                binding.fragmentLobby.isRefreshing = false
            }
            setColorSchemeColors(resources.getColor(R.color.main, context.theme))
        }
    }

    private fun handleUiEvent(event: LobbyUiEvent) = when (event) {
        is LobbyUiEvent.BadRequest -> {
            showSnackBar(R.string.message_bad_request)
        }

        is LobbyUiEvent.UnauthorizedStatus -> {
            showSnackBar(R.string.message_network_error)
        }

        is LobbyUiEvent.Forbidden -> {
            showSnackBar(R.string.message_forbidden)
        }

        is LobbyUiEvent.TooManyRequests -> {
            showSnackBar(R.string.message_too_many_requests)
        }

        is LobbyUiEvent.InternalServerError -> {
            showSnackBar(R.string.message_network_error)
        }

        is LobbyUiEvent.StartEventUrl -> {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.eventUrl.value)))
        }

        is LobbyUiEvent.SetDarkMode -> {
            setDarkMode()
        }
    }
}