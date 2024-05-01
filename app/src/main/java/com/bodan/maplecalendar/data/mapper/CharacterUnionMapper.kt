package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.domain.entity.CharacterUnion
import com.bodan.maplecalendar.data.model.UnionEntity

object CharacterUnionMapper {

    operator fun invoke(unionEntity: UnionEntity): CharacterUnion {
        return CharacterUnion(
            characterUnionLevel = unionEntity.characterUnionLevel,
            characterUnionGrade = unionEntity.characterUnionGrade,
            characterUnionArtifactLevel = unionEntity.characterUnionArtifactLevel,
            characterUnionArtifactExp = unionEntity.characterUnionArtifactExp,
            characterUnionArtifactPoint = unionEntity.characterUnionArtifactPoint
        )
    }
}