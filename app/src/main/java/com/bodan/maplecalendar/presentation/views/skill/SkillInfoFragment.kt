package com.bodan.maplecalendar.presentation.views.skill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bodan.maplecalendar.databinding.FragmentSkillInfoBinding
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkillInfoFragment : Fragment() {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var binding: FragmentSkillInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillInfoBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel

            arguments?.let { argument ->
                val pos = argument.getInt("grade")
                with(rvSkillInfo) {
                    layoutManager = GridLayoutManager(requireContext(), 2)
                    adapter = SkillInfoAdapter(
                        viewModel.characterSkills.value[pos].characterSkills,
                        viewModel
                    )
                    setHasFixedSize(false)
                    requestLayout()
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

        fun newInstance(itemId: Long) = SkillInfoFragment().apply {
            arguments = Bundle().apply {
                putInt("grade", itemId.toInt())
            }
        }
    }
}