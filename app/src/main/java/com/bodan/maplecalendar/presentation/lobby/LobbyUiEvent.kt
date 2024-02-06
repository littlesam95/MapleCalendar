package com.bodan.maplecalendar.presentation.lobby

sealed class LobbyUiEvent {

    data object GoToCharacter : LobbyUiEvent()

    data object BadRequest : LobbyUiEvent()

    data object UnauthorizedStatus : LobbyUiEvent()

    data object Forbidden : LobbyUiEvent()

    data object TooManyRequests : LobbyUiEvent()

    data object InternalServerError : LobbyUiEvent()

    data object StartEventUrl : LobbyUiEvent()

    data object SetDarkMode : LobbyUiEvent()
}
