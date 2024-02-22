package com.bodan.maplecalendar.presentation.equipment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bodan.maplecalendar.databinding.ItemEquipmentAndroidBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentBadgeBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentDefaultBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentEmblemBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentHeartBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentPocketBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentSeedringBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentShieldBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentSubweaponBinding
import com.bodan.maplecalendar.databinding.ItemEquipmentWeaponBinding
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.ANDROID_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.BADGE_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.DEFAULT_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.EMBLEM_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.HEART_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.POCKET_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.SEEDRING_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.SHIELD_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.SUBWEAPON_VIEW_TYPE
import com.bodan.maplecalendar.presentation.equipment.EquipmentUiState.Companion.WEAPON_VIEW_TYPE

class EquipmentListAdapter(private val onItemEquipmentClickListener: OnItemEquipmentClickListener) :
    ListAdapter<EquipmentUiState, RecyclerView.ViewHolder>(equipmentUiStateDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            WEAPON_VIEW_TYPE -> ItemEquipmentWeaponViewHolder(
                ItemEquipmentWeaponBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            EMBLEM_VIEW_TYPE -> ItemEquipmentEmblemViewHolder(
                ItemEquipmentEmblemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            SHIELD_VIEW_TYPE -> ItemEquipmentShieldViewHolder(
                ItemEquipmentShieldBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            SUBWEAPON_VIEW_TYPE -> ItemEquipmentSubweaponViewHolder(
                ItemEquipmentSubweaponBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            BADGE_VIEW_TYPE -> ItemEquipmentBadgeViewHolder(
                ItemEquipmentBadgeBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            POCKET_VIEW_TYPE -> ItemEquipmentPocketViewHolder(
                ItemEquipmentPocketBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            ANDROID_VIEW_TYPE -> ItemEquipmentAndroidViewHolder(
                ItemEquipmentAndroidBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            HEART_VIEW_TYPE -> ItemEquipmentHeartViewHolder(
                ItemEquipmentHeartBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            SEEDRING_VIEW_TYPE -> ItemEquipmentSeedringViewHolder(
                ItemEquipmentSeedringBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> ItemEquipmentDefaultViewHolder(
                ItemEquipmentDefaultBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            DEFAULT_VIEW_TYPE -> (holder as ItemEquipmentDefaultViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentDefault,
                onItemEquipmentClickListener
            )

            WEAPON_VIEW_TYPE -> (holder as ItemEquipmentWeaponViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentWeapon,
                onItemEquipmentClickListener
            )

            EMBLEM_VIEW_TYPE -> (holder as ItemEquipmentEmblemViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentEmblem,
                onItemEquipmentClickListener
            )

            SHIELD_VIEW_TYPE -> (holder as ItemEquipmentShieldViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentShield,
                onItemEquipmentClickListener
            )

            SUBWEAPON_VIEW_TYPE -> (holder as ItemEquipmentSubweaponViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentSubweapon,
                onItemEquipmentClickListener
            )

            BADGE_VIEW_TYPE -> (holder as ItemEquipmentBadgeViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentBadge,
                onItemEquipmentClickListener
            )

            POCKET_VIEW_TYPE -> (holder as ItemEquipmentPocketViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentPocket,
                onItemEquipmentClickListener
            )

            ANDROID_VIEW_TYPE -> (holder as ItemEquipmentAndroidViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentAndroid,
                onItemEquipmentClickListener
            )

            HEART_VIEW_TYPE -> (holder as ItemEquipmentHeartViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentHeart,
                onItemEquipmentClickListener
            )

            SEEDRING_VIEW_TYPE -> (holder as ItemEquipmentSeedringViewHolder).bind(
                currentList[position] as EquipmentUiState.EquipmentSeedring,
                onItemEquipmentClickListener
            )

            else -> {}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            currentList[position] is EquipmentUiState.EquipmentWeapon -> WEAPON_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentEmblem -> EMBLEM_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentShield -> SHIELD_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentSubweapon -> SUBWEAPON_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentBadge -> BADGE_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentPocket -> POCKET_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentAndroid -> ANDROID_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentHeart -> HEART_VIEW_TYPE

            currentList[position] is EquipmentUiState.EquipmentSeedring -> SEEDRING_VIEW_TYPE

            else -> DEFAULT_VIEW_TYPE
        }
    }

    companion object {
        val equipmentUiStateDiffUtil = object : DiffUtil.ItemCallback<EquipmentUiState>() {
            override fun areItemsTheSame(oldItem: EquipmentUiState, newItem: EquipmentUiState) =
                (oldItem.id == newItem.id)

            override fun areContentsTheSame(oldItem: EquipmentUiState, newItem: EquipmentUiState) =
                (oldItem == newItem)
        }
    }

    class ItemEquipmentDefaultViewHolder(private val binding: ItemEquipmentDefaultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentDefault, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentWeaponViewHolder(private val binding: ItemEquipmentWeaponBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentWeapon, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentEmblemViewHolder(private val binding: ItemEquipmentEmblemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentEmblem, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentShieldViewHolder(private val binding: ItemEquipmentShieldBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentShield, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentSubweaponViewHolder(private val binding: ItemEquipmentSubweaponBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentSubweapon, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentBadgeViewHolder(private val binding: ItemEquipmentBadgeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentBadge, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentPocketViewHolder(private val binding: ItemEquipmentPocketBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentPocket, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentAndroidViewHolder(private val binding: ItemEquipmentAndroidBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentAndroid, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentHeartViewHolder(private val binding: ItemEquipmentHeartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentHeart, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }

    class ItemEquipmentSeedringViewHolder(private val binding: ItemEquipmentSeedringBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(equipment: EquipmentUiState.EquipmentSeedring, onClickListener: OnItemEquipmentClickListener) {
            binding.item = equipment
            binding.onItemEquipmentClickListener = onClickListener
        }
    }
}