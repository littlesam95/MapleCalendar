package com.bodan.maplecalendar.presentation.views.hyperstat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bodan.maplecalendar.databinding.FragmentHyperStatPresetBinding
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HyperStatPresetFragment : Fragment() {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var binding: FragmentHyperStatPresetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHyperStatPresetBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel

            arguments?.let { argument ->
                val pos = argument.getInt("preset")

                with(rvHyperStatPreset) {
                    layoutManager = LinearLayoutManager(requireActivity())
                    viewModel.characterHyperStat.value?.let { hyperStat ->
                        adapter = HyperStatInfoAdapter(hyperStat.hyperStats[pos])
                    }
                    setHasFixedSize(false)
                }
            }
        }

        return binding.root
    }

    companion object {

        fun newInstance(itemId: Long) = HyperStatPresetFragment().apply {
            arguments = Bundle().apply {
                putInt("preset", itemId.toInt())
            }
        }
    }
}