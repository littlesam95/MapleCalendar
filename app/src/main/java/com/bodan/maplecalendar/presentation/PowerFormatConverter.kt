package com.bodan.maplecalendar.presentation

import java.text.DecimalFormat

object PowerFormatConverter {

    fun convertPowerFormat(stat: String): String {
        var result = ""
        for (index in stat.reversed().indices) {
            if (index == 4) {
                result += " 만"
            } else if (index == 8) {
                result += " 억"
            }
            result += stat.reversed()[index]
        }

        return result.reversed()
    }

    fun convertPercentFormat(stat: String): String {
        return "${stat}%"
    }

    fun convertCommaFormat(stat: String): String {
        return DecimalFormat("#,###").format(stat.toInt())
    }

    fun convertAttackSpeedFormat(stat: String): String {
        return "${stat}단계"
    }

    fun convertDojangFormat(stat: Int): String {
        return "${stat}층"
    }
}