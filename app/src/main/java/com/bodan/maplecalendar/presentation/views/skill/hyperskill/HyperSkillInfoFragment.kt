package com.bodan.maplecalendar.presentation.views.skill.hyperskill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bodan.maplecalendar.databinding.FragmentHyperSkillInfoBinding
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HyperSkillInfoFragment : Fragment() {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var binding: FragmentHyperSkillInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHyperSkillInfoBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel

            arguments?.let { argument ->
                val pos = argument.getInt("hyper")
                with(rvHyperSkillInfo) {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = HyperSkillInfoAdapter(
                        viewModel.characterHyperSkills.value[pos].characterSkills,
                        viewModel
                    )
                    setHasFixedSize(false)
                }
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.root.requestLayout()
    }

    companion object {

        fun newInstance(itemId: Long) = HyperSkillInfoFragment().apply {
            arguments = Bundle().apply {
                putInt("hyper", itemId.toInt())
            }
        }
    }
}