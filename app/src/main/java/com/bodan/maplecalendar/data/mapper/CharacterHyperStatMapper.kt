package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.HyperStatEntity
import com.bodan.maplecalendar.domain.entity.CharacterHyperStat
import com.bodan.maplecalendar.domain.entity.CharacterHyperStatInfo

object CharacterHyperStatMapper {

    operator fun invoke(hyperStatEntity: HyperStatEntity): CharacterHyperStat {
        val firstPreset = mutableListOf<CharacterHyperStatInfo>()
        val secondPreset = mutableListOf<CharacterHyperStatInfo>()
        val thirdPreset = mutableListOf<CharacterHyperStatInfo>()

        with(hyperStatEntity) {
            hyperStatFirstPreset.forEach { hyperStatInfo ->
                firstPreset.add(
                    CharacterHyperStatInfo(
                        statType = hyperStatInfo.statType,
                        statPoint = hyperStatInfo.statPoint,
                        statLevel = hyperStatInfo.statLevel,
                        statIncrease = hyperStatInfo.statIncrease
                    )
                )
            }
            hyperStatSecondPreset.forEach { hyperStatInfo ->
                secondPreset.add(
                    CharacterHyperStatInfo(
                        statType = hyperStatInfo.statType,
                        statPoint = hyperStatInfo.statPoint,
                        statLevel = hyperStatInfo.statLevel,
                        statIncrease = hyperStatInfo.statIncrease
                    )
                )
            }
            hyperStatThirdPreset.forEach { hyperStatInfo ->
                thirdPreset.add(
                    CharacterHyperStatInfo(
                        statType = hyperStatInfo.statType,
                        statPoint = hyperStatInfo.statPoint,
                        statLevel = hyperStatInfo.statLevel,
                        statIncrease = hyperStatInfo.statIncrease
                    )
                )
            }
        }

        return CharacterHyperStat(
            hyperStatFirstPreset = firstPreset.toList(),
            hyperStatFirstPresetRemainPoint = hyperStatEntity.hyperStatFirstPresetRemainPoint,
            hyperStatSecondPreset = secondPreset.toList(),
            hyperStatSecondPresetRemainPoint = hyperStatEntity.hyperStatSecondPresetRemainPoint,
            hyperStatThirdPreset = thirdPreset.toList(),
            hyperStatThirdPresetRemainPoint = hyperStatEntity.hyperStatThirdPresetRemainPoint
        )
    }
}