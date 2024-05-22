package com.bodan.maplecalendar.presentation.views.skill

sealed class SkillUiEvent {

    data object GetSkillDetail : SkillUiEvent()

    data object CloseSkillDetail : SkillUiEvent()

    data object BadRequest : SkillUiEvent()

    data object UnauthorizedStatus : SkillUiEvent()

    data object Forbidden : SkillUiEvent()

    data object TooManyRequests : SkillUiEvent()

    data object InternalServerError : SkillUiEvent()

    data object SetDarkMode : SkillUiEvent()
}