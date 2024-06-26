package com.bodan.maplecalendar.presentation.views.lobby

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentLobbyBinding
import com.bodan.maplecalendar.presentation.config.BaseFragment
import com.bodan.maplecalendar.presentation.views.CharacterActivity
import com.bodan.maplecalendar.presentation.views.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LobbyFragment : BaseFragment<FragmentLobbyBinding>(R.layout.fragment_lobby) {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var eventListAdapter: EventListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()
        collectDarkMode()

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

    private fun collectDarkMode() {
        lifecycleScope.launch {
            viewModel.getDarkMode().collectLatest { isDarkMode ->
                setDarkMode(isDarkMode)
            }
        }
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
        is LobbyUiEvent.GoToCharacter -> {
            val intent = Intent(requireContext(), CharacterActivity::class.java).apply {
                action = Intent.ACTION_MAIN
                addCategory(Intent.CATEGORY_LAUNCHER)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        }

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

        is LobbyUiEvent.GetDarkMode -> {
            setDarkMode(event.isDarkMode)
        }

        is LobbyUiEvent.SelectSearchDate -> {
            findNavController().navigateSafely(R.id.action_lobby_to_search_date)
        }

        is LobbyUiEvent.StartEventUrl -> {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.eventUrl.value)))
        }

        else -> {}
    }
}