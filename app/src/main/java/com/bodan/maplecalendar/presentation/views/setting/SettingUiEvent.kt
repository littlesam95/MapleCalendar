package com.bodan.maplecalendar.presentation.views.setting

sealed class SettingUiEvent {

    data object BadRequest : SettingUiEvent()

    data object UnauthorizedStatus : SettingUiEvent()

    data object Forbidden : SettingUiEvent()

    data object TooManyRequests : SettingUiEvent()

    data object InternalServerError : SettingUiEvent()

    data object ChangeCharacterName : SettingUiEvent()

    data object CloseChangeCharacterName : SettingUiEvent()

    data object SetPushNotification : SettingUiEvent()

    data object AllowPushNotification : SettingUiEvent()

    data object CancelPushNotification : SettingUiEvent()

    data object SetDarkMode : SettingUiEvent()
}
