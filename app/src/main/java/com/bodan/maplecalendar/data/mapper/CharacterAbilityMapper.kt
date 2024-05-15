package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.AbilityEntity
import com.bodan.maplecalendar.domain.entity.CharacterAbility
import com.bodan.maplecalendar.domain.entity.CharacterAbilityInfo
import com.bodan.maplecalendar.domain.entity.CharacterAbilityPreset

object CharacterAbilityMapper {

    operator fun invoke(abilityEntity: AbilityEntity): CharacterAbility {
        val abilityFirstPresetInfo = mutableListOf<CharacterAbilityInfo>()
        val abilitySecondPresetInfo = mutableListOf<CharacterAbilityInfo>()
        val abilityThirdPresetInfo = mutableListOf<CharacterAbilityInfo>()

        val abilitys = mutableListOf<CharacterAbilityPreset>()

        abilityEntity.abilityFirstPreset.abilityInfo.forEach { abilityInfo ->
            abilityFirstPresetInfo.add(
                CharacterAbilityInfo(
                    abilityNo = abilityInfo.abilityNo,
                    abilityGrade = abilityInfo.abilityGrade,
                    abilityValue = abilityInfo.abilityValue
                )
            )
        }
        abilitys.add(
            CharacterAbilityPreset(
                abilityEntity.abilityFirstPreset.abilityPresetGrade,
                abilityFirstPresetInfo
            )
        )

        abilityEntity.abilitySecondPreset.abilityInfo.forEach { abilityInfo ->
            abilitySecondPresetInfo.add(
                CharacterAbilityInfo(
                    abilityNo = abilityInfo.abilityNo,
                    abilityGrade = abilityInfo.abilityGrade,
                    abilityValue = abilityInfo.abilityValue
                )
            )
        }
        abilitys.add(
            CharacterAbilityPreset(
                abilityEntity.abilitySecondPreset.abilityPresetGrade,
                abilitySecondPresetInfo
            )
        )

        abilityEntity.abilityThirdPreset.abilityInfo.forEach { abilityInfo ->
            abilityThirdPresetInfo.add(
                CharacterAbilityInfo(
                    abilityNo = abilityInfo.abilityNo,
                    abilityGrade = abilityInfo.abilityGrade,
                    abilityValue = abilityInfo.abilityValue
                )
            )
        }
        abilitys.add(
            CharacterAbilityPreset(
                abilityEntity.abilityThirdPreset.abilityPresetGrade,
                abilityThirdPresetInfo
            )
        )

        return CharacterAbility(
            remainFame = abilityEntity.remainFame.toString(),
            abilitys = abilitys
        )
    }
}