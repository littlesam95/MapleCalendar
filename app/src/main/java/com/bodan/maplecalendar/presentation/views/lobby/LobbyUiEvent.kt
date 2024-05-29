package com.bodan.maplecalendar.presentation.views.lobby

sealed class LobbyUiEvent {

    data object GoToCharacter : LobbyUiEvent()

    data object SelectSearchDate : LobbyUiEvent()

    data object CloseSearchDate : LobbyUiEvent()

    data object StartEventUrl : LobbyUiEvent()

    data class GetDarkMode(val isDarkMode: Boolean?) : LobbyUiEvent()

    data object BadRequest : LobbyUiEvent()

    data object UnauthorizedStatus : LobbyUiEvent()

    data object Forbidden : LobbyUiEvent()

    data object TooManyRequests : LobbyUiEvent()

    data object InternalServerError : LobbyUiEvent()
}
