package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.BasicEntity
import com.bodan.maplecalendar.domain.entity.CharacterBasic

object CharacterBasicMapper {

    operator fun invoke(basicEntity: BasicEntity): CharacterBasic =
        CharacterBasic(
            characterLevel = basicEntity.characterLevel.toString(),
            characterClass = basicEntity.characterClass,
            worldName = basicEntity.worldName,
            characterGuildName = basicEntity.characterGuildName,
            characterImage = basicEntity.characterImage,
            characterGender = basicEntity.characterGender
        )
}