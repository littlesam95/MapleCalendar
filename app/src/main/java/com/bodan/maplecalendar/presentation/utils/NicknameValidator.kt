package com.bodan.maplecalendar.presentation.utils

object NicknameValidator {

    private val nicknameRegex: Regex = "^[가-힣a-zA-Z0-9]{2,12}$".toRegex()

    fun validateNickname(nickname: CharSequence): Boolean {
        var nicknameSize = 0
        for (word in nickname) {
            if ((word >= 'a') && (word <= 'z')) {
                nicknameSize++
            } else if ((word >= 'A') && (word <= 'Z')) {
                nicknameSize++
            } else if ((word >= '0') && (word <= '9')) {
                nicknameSize++
            } else {
                nicknameSize += 2
            }
        }
        return nickname.matches(nicknameRegex) && (nicknameSize >= 4) && (nicknameSize <= 12)
    }
}