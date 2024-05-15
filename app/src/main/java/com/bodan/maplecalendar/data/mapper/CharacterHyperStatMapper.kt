package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.HyperStatEntity
import com.bodan.maplecalendar.domain.entity.CharacterHyperStat
import com.bodan.maplecalendar.domain.entity.CharacterHyperStatInfo

object CharacterHyperStatMapper {

    operator fun invoke(hyperStatEntity: HyperStatEntity): CharacterHyperStat {
        val firstPreset = mutableListOf<CharacterHyperStatInfo>()
        val secondPreset = mutableListOf<CharacterHyperStatInfo>()
        val thirdPreset = mutableListOf<CharacterHyperStatInfo>()

        val hyperStats = mutableListOf<List<CharacterHyperStatInfo>>()
        val hyperStatRemainPoints = mutableListOf<Int>()

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
            hyperStats.add(firstPreset)

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
            hyperStats.add(secondPreset)

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
            hyperStats.add(thirdPreset)

            hyperStatRemainPoints.add(hyperStatFirstPresetRemainPoint)
            hyperStatRemainPoints.add(hyperStatSecondPresetRemainPoint)
            hyperStatRemainPoints.add(hyperStatThirdPresetRemainPoint)
        }

        return CharacterHyperStat(
            hyperStats = hyperStats.toList(),
            hyperStatRemainPoints = hyperStatRemainPoints.toList()
        )
    }
}