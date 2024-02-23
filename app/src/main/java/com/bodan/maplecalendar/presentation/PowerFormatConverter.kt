package com.bodan.maplecalendar.presentation

import java.text.DecimalFormat

object PowerFormatConverter {

    fun convertPowerFormat(stat: String?): String {
        when (stat) {
            null -> return "-"

            else -> {
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
        }
    }

    fun convertPercentFormat(stat: String?): String {
        return when (stat) {
            null -> "-"

            else -> "${stat}%"
        }
    }

    fun convertCommaFormat(stat: String?): String {
        return when (stat) {
            null -> "-"

            else -> DecimalFormat("#,###").format(stat.toInt())
        }
    }

    fun convertAttackSpeedFormat(stat: String?): String {
        return when (stat) {
            null -> "-"

            else -> "${stat}단계"
        }
    }

    fun convertDojangFormat(stat: Int): String {
        return "${stat}층"
    }
}