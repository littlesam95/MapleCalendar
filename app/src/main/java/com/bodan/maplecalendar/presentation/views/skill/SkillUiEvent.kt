package com.bodan.maplecalendar.presentation.views.skill

sealed class SkillUiEvent {

    data object GetSkillDetail : SkillUiEvent()

    data object CloseSkillDetail : SkillUiEvent()

    data object GetLinkSkill : SkillUiEvent()

    data object CloseLinkSkill : SkillUiEvent()

    data object GetHyperSkill : SkillUiEvent()

    data object CloseHyperSkill : SkillUiEvent()

    data object GetHyperSkillDetail : SkillUiEvent()

    data object GetLinkSkillDetail : SkillUiEvent()

    data object BadRequest : SkillUiEvent()

    data object UnauthorizedStatus : SkillUiEvent()

    data object Forbidden : SkillUiEvent()

    data object TooManyRequests : SkillUiEvent()

    data object InternalServerError : SkillUiEvent()

    data object SetDarkMode : SkillUiEvent()
}