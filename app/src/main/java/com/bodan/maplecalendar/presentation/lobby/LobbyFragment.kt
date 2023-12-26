package com.bodan.maplecalendar.presentation.lobby

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentLobbyBinding
import com.bodan.maplecalendar.presentation.BaseFragment
import com.bodan.maplecalendar.presentation.MainViewModel

class LobbyFragment : BaseFragment<FragmentLobbyBinding>(R.layout.fragment_lobby) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        collectLatestFlow(viewModel.lobbyUiEvent) { handleUiEvent(it) }
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
    }
}