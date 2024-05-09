package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.data.model.StatEntity

object CharacterStatMapper {

    operator fun invoke(statEntity: StatEntity): List<FinalStat> {
        val result = mutableListOf<FinalStat>()

        statEntity.finalStats.forEach { stat ->
            result.add(FinalStat(statName = stat.statName, statValue = stat.statValue))
        }

        return result
    }
}