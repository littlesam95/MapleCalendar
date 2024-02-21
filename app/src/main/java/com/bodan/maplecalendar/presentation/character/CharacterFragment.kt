package com.bodan.maplecalendar.presentation.character

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.FragmentCharacterBinding
import com.bodan.maplecalendar.presentation.BaseFragment
import com.bodan.maplecalendar.presentation.CharacterViewModel

class CharacterFragment : BaseFragment<FragmentCharacterBinding>(R.layout.fragment_character) {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var characterDefaultStatListAdapter: CharacterDefaultStatListAdapter
    private lateinit var characterMainStatListAdapter: CharacterMainStatListAdapter
    private lateinit var characterEtcStatListAdapter: CharacterEtcStatListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListAdapter()
        initRecyclerView()

        binding.vm = viewModel
        binding.defaultStatListAdapter = characterDefaultStatListAdapter
        binding.mainStatListAdapter = characterMainStatListAdapter
        binding.etcStatListAdapter = characterEtcStatListAdapter

        collectLatestFlow(viewModel.characterUiEvent) { handleUiEvent(it) }
    }

    private fun initListAdapter() {
        characterDefaultStatListAdapter = CharacterDefaultStatListAdapter()
        characterMainStatListAdapter = CharacterMainStatListAdapter()
        characterEtcStatListAdapter = CharacterEtcStatListAdapter()
    }

    private fun initRecyclerView() {
        binding.rvDefaultStatCharacter.setHasFixedSize(false)
        binding.rvMainStatCharacter.setHasFixedSize(false)
        binding.rvEtcStatCharacter.setHasFixedSize(false)
    }

    private fun handleUiEvent(event: CharacterUiEvent) = when (event) {
        is CharacterUiEvent.BadRequest -> {
            showSnackBar(R.string.message_bad_request)
        }

        is CharacterUiEvent.UnauthorizedStatus -> {
            showSnackBar(R.string.message_network_error)
        }

        is CharacterUiEvent.Forbidden -> {
            showSnackBar(R.string.message_forbidden)
        }

        is CharacterUiEvent.TooManyRequests -> {
            showSnackBar(R.string.message_too_many_requests)
        }

        is CharacterUiEvent.InternalServerError -> {
            showSnackBar(R.string.message_network_error)
        }

        is CharacterUiEvent.SetDarkMode -> {
            setDarkMode()
        }
    }
}