package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.CharacterPopularity
import com.bodan.maplecalendar.data.model.PopularityEntity

object CharacterPopularityMapper {

    operator fun invoke(popularityEntity: PopularityEntity): CharacterPopularity {
        return CharacterPopularity(
            characterPopularity = popularityEntity.characterPopularity
        )
    }
}