package com.bodan.maplecalendar.presentation.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemCharacterDefaultStatBinding
import com.bodan.maplecalendar.databinding.ItemCharacterEtcStatBinding
import com.bodan.maplecalendar.databinding.ItemCharacterMainStatBinding
import com.bodan.maplecalendar.presentation.character.CharacterUiState.Companion.DEFAULT_STAT_VIEW_TYPE
import com.bodan.maplecalendar.presentation.character.CharacterUiState.Companion.ETC_STAT_VIEW_TYPE
import com.bodan.maplecalendar.presentation.character.CharacterUiState.Companion.MAIN_STAT_VIEW_TYPE

class CharacterEtcStatListAdapter :
    ListAdapter<CharacterUiState, RecyclerView.ViewHolder>(characterUiStateDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DEFAULT_STAT_VIEW_TYPE -> CharacterDefaultStatViewHolder(
                ItemCharacterDefaultStatBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            MAIN_STAT_VIEW_TYPE -> CharacterMainStatViewHolder(
                ItemCharacterMainStatBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> CharacterEtcStatViewHolder(
                ItemCharacterEtcStatBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            DEFAULT_STAT_VIEW_TYPE -> (holder as CharacterDefaultStatViewHolder).bind(currentList[position] as CharacterUiState.CharacterDefaultStat)

            MAIN_STAT_VIEW_TYPE -> (holder as CharacterMainStatViewHolder).bind(currentList[position] as CharacterUiState.CharacterMainStat)

            ETC_STAT_VIEW_TYPE -> (holder as CharacterEtcStatViewHolder).bind(currentList[position] as CharacterUiState.CharacterEtcStat)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            currentList[position] is CharacterUiState.CharacterDefaultStat -> DEFAULT_STAT_VIEW_TYPE

            currentList[position] is CharacterUiState.CharacterMainStat -> MAIN_STAT_VIEW_TYPE

            else -> ETC_STAT_VIEW_TYPE
        }
    }

    companion object {
        val characterUiStateDiffUtil = object : DiffUtil.ItemCallback<CharacterUiState>() {
            override fun areItemsTheSame(oldItem: CharacterUiState, newItem: CharacterUiState) =
                (oldItem.id == newItem.id)

            override fun areContentsTheSame(oldItem: CharacterUiState, newItem: CharacterUiState) =
                (oldItem == newItem)
        }
    }

    class CharacterDefaultStatViewHolder(private val binding: ItemCharacterDefaultStatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(stat: CharacterUiState.CharacterDefaultStat) {
            binding.stat = stat
        }
    }

    class CharacterMainStatViewHolder(private val binding: ItemCharacterMainStatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(stat: CharacterUiState.CharacterMainStat) {
            binding.stat = stat
        }
    }

    class CharacterEtcStatViewHolder(private val binding: ItemCharacterEtcStatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(stat: CharacterUiState.CharacterEtcStat) {
            binding.stat = stat
        }
    }
}