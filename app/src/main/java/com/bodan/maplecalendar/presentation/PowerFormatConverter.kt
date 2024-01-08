package com.bodan.maplecalendar.presentation

object PowerFormatConverter {

    fun convertPowerFormat(power: String): String {
        var result = ""
        for (index in power.reversed().indices) {
            if (index == 4) {
                result += " 만"
            } else if (index == 8) {
                result += " 억"
            }
            result += power.reversed()[index]
        }

        return result.reversed()
    }
}