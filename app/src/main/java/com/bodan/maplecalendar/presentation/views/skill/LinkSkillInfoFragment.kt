package com.bodan.maplecalendar.presentation.views.skill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bodan.maplecalendar.databinding.FragmentLinkSkillInfoBinding
import com.bodan.maplecalendar.presentation.views.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LinkSkillInfoFragment : Fragment() {

    private val viewModel: CharacterViewModel by activityViewModels()
    private lateinit var binding: FragmentLinkSkillInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLinkSkillInfoBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel

            arguments?.let { argument ->
                val pos = argument.getInt("preset")
                with(rvLinkSkillInfo) {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = LinkSkillInfoAdapter(
                        viewModel.characterLinkSkills.value[pos],
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

        fun newInstance(itemId: Long) = LinkSkillInfoFragment().apply {
            arguments = Bundle().apply {
                putInt("preset", itemId.toInt())
            }
        }
    }
}