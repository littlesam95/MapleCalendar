package com.bodan.maplecalendar.presentation.character

sealed class CharacterUiEvent {

    data object BadRequest : CharacterUiEvent()

    data object UnauthorizedStatus : CharacterUiEvent()

    data object Forbidden : CharacterUiEvent()

    data object TooManyRequests : CharacterUiEvent()

    data object InternalServerError : CharacterUiEvent()

    data object SetDarkMode : CharacterUiEvent()
}