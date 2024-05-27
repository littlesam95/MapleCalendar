package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.LinkSkillEntity
import com.bodan.maplecalendar.domain.entity.CharacterLinkSkill
import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo

object CharacterLinkSkillMapper {

    operator fun invoke(linkSkillEntity: LinkSkillEntity): CharacterLinkSkill {
        val newCharacterLinkSkills = mutableListOf<List<CharacterSkillInfo>>()

        val characterLinkSkillsFirst = mutableListOf<CharacterSkillInfo>()
        linkSkillEntity.characterLinkSkillFirstPreset.forEach { linkSkillInfo ->
            characterLinkSkillsFirst.add(
                CharacterSkillInfo(
                    skillName = linkSkillInfo.skillName,
                    skillDescription = linkSkillInfo.skillDescription,
                    skillLevel = linkSkillInfo.skillLevel.toString(),
                    skillLevelNext = (linkSkillInfo.skillLevel + 1).toString(),
                    skillEffect = linkSkillInfo.skillEffect,
                    skillEffectNext = null,
                    skillIcon = linkSkillInfo.skillIcon
                )
            )
        }
        newCharacterLinkSkills.add(characterLinkSkillsFirst)

        val characterLinkSkillsSecond = mutableListOf<CharacterSkillInfo>()
        linkSkillEntity.characterLinkSkillSecondPreset.forEach { linkSkillInfo ->
            characterLinkSkillsSecond.add(
                CharacterSkillInfo(
                    skillName = linkSkillInfo.skillName,
                    skillDescription = linkSkillInfo.skillDescription,
                    skillLevel = linkSkillInfo.skillLevel.toString(),
                    skillLevelNext = (linkSkillInfo.skillLevel + 1).toString(),
                    skillEffect = linkSkillInfo.skillEffect,
                    skillEffectNext = null,
                    skillIcon = linkSkillInfo.skillIcon
                )
            )
        }
        newCharacterLinkSkills.add(characterLinkSkillsSecond)

        val characterLinkSkillsThird = mutableListOf<CharacterSkillInfo>()
        linkSkillEntity.characterLinkSkillThirdPreset.forEach { linkSkillInfo ->
            characterLinkSkillsThird.add(
                CharacterSkillInfo(
                    skillName = linkSkillInfo.skillName,
                    skillDescription = linkSkillInfo.skillDescription,
                    skillLevel = linkSkillInfo.skillLevel.toString(),
                    skillLevelNext = (linkSkillInfo.skillLevel + 1).toString(),
                    skillEffect = linkSkillInfo.skillEffect,
                    skillEffectNext = null,
                    skillIcon = linkSkillInfo.skillIcon
                )
            )
        }
        newCharacterLinkSkills.add(characterLinkSkillsThird)

        return CharacterLinkSkill(
            characterLinkSkills = newCharacterLinkSkills.toList(),
            characterOwnedLinkSkill = CharacterSkillInfo(
                skillName = linkSkillEntity.characterOwnedLinkSkill.skillName,
                skillDescription = linkSkillEntity.characterOwnedLinkSkill.skillDescription,
                skillLevel = linkSkillEntity.characterOwnedLinkSkill.skillLevel.toString(),
                skillLevelNext = (linkSkillEntity.characterOwnedLinkSkill.skillLevel + 1).toString(),
                skillEffect = linkSkillEntity.characterOwnedLinkSkill.skillEffect,
                skillEffectNext = null,
                skillIcon = linkSkillEntity.characterOwnedLinkSkill.skillIcon
            )
        )
    }
}