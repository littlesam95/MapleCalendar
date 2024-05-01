package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.data.model.StatEntity

object CharacterStatMapper {

    operator fun invoke(statEntity: StatEntity): List<FinalStat> {
        return statEntity.finalStats
    }
}