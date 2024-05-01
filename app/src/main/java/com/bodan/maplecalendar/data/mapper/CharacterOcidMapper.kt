package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.OcidEntity
import com.bodan.maplecalendar.domain.entity.CharacterOcid

object CharacterOcidMapper {

    operator fun invoke(ocidEntity: OcidEntity): CharacterOcid =
        CharacterOcid(ocidEntity.ocid)
}