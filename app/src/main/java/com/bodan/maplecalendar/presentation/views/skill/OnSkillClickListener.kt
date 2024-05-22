package com.bodan.maplecalendar.presentation.views.skill

import com.bodan.maplecalendar.domain.entity.CharacterSkillInfo

interface OnSkillClickListener {

    fun onSkillClicked(skillInfo: CharacterSkillInfo)
}