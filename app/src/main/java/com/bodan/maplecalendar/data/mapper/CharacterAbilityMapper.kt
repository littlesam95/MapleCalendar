package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.AbilityEntity
import com.bodan.maplecalendar.domain.entity.CharacterAbility
import com.bodan.maplecalendar.domain.entity.CharacterAbilityInfo
import com.bodan.maplecalendar.domain.entity.CharacterAbilityPreset

object CharacterAbilityMapper {

    operator fun invoke(abilityEntity: AbilityEntity): CharacterAbility {
        return CharacterAbility(
            remainFame = abilityEntity.remainFame,
            abilityFirstPreset = CharacterAbilityPreset(
                abilityPresetGrade = abilityEntity.abilityFirstPreset.abilityPresetGrade,
                abilityInfo = CharacterAbilityInfo(
                    abilityNo = abilityEntity.abilityFirstPreset.abilityInfo.abilityNo,
                    abilityGrade = abilityEntity.abilityFirstPreset.abilityInfo.abilityGrade,
                    abilityValue = abilityEntity.abilityFirstPreset.abilityInfo.abilityValue
                )
            ),
            abilitySecondPreset = CharacterAbilityPreset(
                abilityPresetGrade = abilityEntity.abilitySecondPreset.abilityPresetGrade,
                abilityInfo = CharacterAbilityInfo(
                    abilityNo = abilityEntity.abilitySecondPreset.abilityInfo.abilityNo,
                    abilityGrade = abilityEntity.abilitySecondPreset.abilityInfo.abilityGrade,
                    abilityValue = abilityEntity.abilitySecondPreset.abilityInfo.abilityValue
                )
            ),
            abilityThirdPreset = CharacterAbilityPreset(
                abilityPresetGrade = abilityEntity.abilityThirdPreset.abilityPresetGrade,
                abilityInfo = CharacterAbilityInfo(
                    abilityNo = abilityEntity.abilityThirdPreset.abilityInfo.abilityNo,
                    abilityGrade = abilityEntity.abilityThirdPreset.abilityInfo.abilityGrade,
                    abilityValue = abilityEntity.abilityThirdPreset.abilityInfo.abilityValue
                )
            )
        )
    }
}