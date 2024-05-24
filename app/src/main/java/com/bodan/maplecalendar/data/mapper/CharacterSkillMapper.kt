package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.SkillEntity
import com.bodan.maplecalendar.domain.entity.CharacterSkill
import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo

object CharacterSkillMapper {

    operator fun invoke(skillEntity: SkillEntity): CharacterSkill {
        val newCharacterSkills = mutableListOf<CharacterSkillInfo>()

        skillEntity.characterSkill.forEach { skill ->
            newCharacterSkills.add(
                CharacterSkillInfo(
                    skillName = skill.skillName,
                    skillDescription = skill.skillDescription,
                    skillLevel = skill.skillLevel.toString(),
                    skillLevelNext = (skill.skillLevel + 1).toString(),
                    skillEffect = skill.skillEffect,
                    skillEffectNext = skill.skillEffectNext,
                    skillIcon = skill.skillIcon
                )
            )
        }

        return CharacterSkill(
            characterClass = skillEntity.characterClass,
            characterSkillGrade = skillEntity.characterSkillGrade,
            characterSkills = newCharacterSkills
        )
    }
}