package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.CharacterItemEquipment
import com.bodan.maplecalendar.data.model.ItemEquipmentEntity

object CharacterItemEquipmentMapper {

    operator fun invoke(itemEquipmentEntity: ItemEquipmentEntity): CharacterItemEquipment {
        return CharacterItemEquipment(
            itemEquipments = itemEquipmentEntity.itemEquipments,
            itemTitle = itemEquipmentEntity.itemTitle
        )
    }
}