package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.CharacterDojang
import com.bodan.maplecalendar.data.model.DojangEntity

object CharacterDojangMapper {

    operator fun invoke(dojangEntity: DojangEntity): CharacterDojang {
        return CharacterDojang(
            characterDojangBestFloor = dojangEntity.characterDojangBestFloor
        )
    }
}