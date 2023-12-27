package com.bodan.maplecalendar.presentation.setting

data class SettingUiState(
    val characterNameValidState: CharacterNameValidState = CharacterNameValidState.NONE
) {
    val isSubmitBtnEnable: Boolean = (characterNameValidState == CharacterNameValidState.VALID)
}
enum class CharacterNameValidState {
    NONE, VALID
}