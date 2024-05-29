package com.bodan.maplecalendar.presentation.views.character

sealed class CharacterUiEvent {

    data object GetHyperStat : CharacterUiEvent()

    data object CloseHyperStat : CharacterUiEvent()

    data object GetAbility : CharacterUiEvent()

    data object CloseAbility : CharacterUiEvent()

    data class GetDarkMode(val isDarkMode: Boolean?) : CharacterUiEvent()

    data object BadRequest : CharacterUiEvent()

    data object UnauthorizedStatus : CharacterUiEvent()

    data object Forbidden : CharacterUiEvent()

    data object TooManyRequests : CharacterUiEvent()

    data object InternalServerError : CharacterUiEvent()
}