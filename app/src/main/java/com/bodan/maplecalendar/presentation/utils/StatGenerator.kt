package com.bodan.maplecalendar.presentation.utils

import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.presentation.views.character.CharacterUiState

object StatGenerator {

    fun getDefaultStats(finalStats: List<FinalStat>): List<CharacterUiState.CharacterDefaultStat> {
        val result = MutableList(3 * 2) { CharacterUiState.CharacterDefaultStat("", "") }
        finalStats.forEach { finalStat ->
            when (finalStat.statName) {
                "STR" -> {
                    result[2] =
                        CharacterUiState.CharacterDefaultStat(
                            "STR",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "DEX" -> {
                    result[3] =
                        CharacterUiState.CharacterDefaultStat(
                            "DEX",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "INT" -> {
                    result[4] =
                        CharacterUiState.CharacterDefaultStat(
                            "INT",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "LUK" -> {
                    result[5] =
                        CharacterUiState.CharacterDefaultStat(
                            "LUK",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "HP" -> {
                    result[0] =
                        CharacterUiState.CharacterDefaultStat(
                            "HP",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "MP" -> {
                    result[1] =
                        CharacterUiState.CharacterDefaultStat(
                            "MP",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }
            }
        }

        return result
    }

    fun getMainStats(finalStats: List<FinalStat>): MutableList<CharacterUiState.CharacterMainStat> {
        val result = MutableList(8 * 2) { CharacterUiState.CharacterMainStat("", "") }
        finalStats.forEach { finalStat ->
            when (finalStat.statName) {
                "최대 스탯공격력" -> {
                    result[0] =
                        CharacterUiState.CharacterMainStat(
                            "스탯 공격력",
                            PowerFormatConverter.convertPowerFormat(finalStat.statValue)
                        )
                }

                "데미지" -> {
                    result[1] =
                        CharacterUiState.CharacterMainStat(
                            "데미지",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "최종 데미지" -> {
                    result[2] =
                        CharacterUiState.CharacterMainStat(
                            "최종 데미지",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "보스 몬스터 데미지" -> {
                    result[3] =
                        CharacterUiState.CharacterMainStat(
                            "보스 몬스터 데미지",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "방어율 무시" -> {
                    result[4] =
                        CharacterUiState.CharacterMainStat(
                            "방어율 무시",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "일반 몬스터 데미지" -> {
                    result[5] =
                        CharacterUiState.CharacterMainStat(
                            "일반 몬스터 데미지",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "공격력" -> {
                    result[6] =
                        CharacterUiState.CharacterMainStat(
                            "공격력",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "크리티컬 확률" -> {
                    result[7] =
                        CharacterUiState.CharacterMainStat(
                            "크리티컬 확률",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "마력" -> {
                    result[8] =
                        CharacterUiState.CharacterMainStat(
                            "마력",
                            PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                        )
                }

                "크리티컬 데미지" -> {
                    result[9] =
                        CharacterUiState.CharacterMainStat(
                            "크리티컬 데미지",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "버프 지속시간" -> {
                    result[11] =
                        CharacterUiState.CharacterMainStat(
                            "버프 지속시간",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "재사용 대기시간 미적용" -> {
                    result[12] =
                        CharacterUiState.CharacterMainStat(
                            "재사용 대기시간 미적용",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "속성 내성 무시" -> {
                    result[13] =
                        CharacterUiState.CharacterMainStat(
                            "속성 내성 무시",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "상태이상 추가 데미지" -> {
                    result[14] =
                        CharacterUiState.CharacterMainStat(
                            "상태이상 추가 데미지",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }

                "소환수 지속시간 증가" -> {
                    result[15] =
                        CharacterUiState.CharacterMainStat(
                            "소환수 지속시간 증가",
                            PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                        )
                }
            }
        }

        return result
    }

    fun getEtcStats(finalStats: List<FinalStat>): List<CharacterUiState.CharacterEtcStat> {
        val result = MutableList(6 * 2) { CharacterUiState.CharacterEtcStat("", "") }
        finalStats.forEach { finalStat ->
            when (finalStat.statName) {
                "메소 획득량" -> {
                    result[0] = CharacterUiState.CharacterEtcStat(
                        "메소 획득량",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "스타포스" -> {
                    result[1] = CharacterUiState.CharacterEtcStat(
                        "스타포스",
                        PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                    )
                }

                "아이템 드롭률" -> {
                    result[2] = CharacterUiState.CharacterEtcStat(
                        "아이템 드롭률",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "아케인포스" -> {
                    result[3] = CharacterUiState.CharacterEtcStat(
                        "아케인포스",
                        PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                    )
                }

                "추가 경험치 획득" -> {
                    result[4] = CharacterUiState.CharacterEtcStat(
                        "추가 경험치 획득",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "어센틱포스" -> {
                    result[5] = CharacterUiState.CharacterEtcStat(
                        "어센틱포스",
                        PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                    )
                }

                "방어력" -> {
                    result[6] = CharacterUiState.CharacterEtcStat(
                        "방어력",
                        PowerFormatConverter.convertCommaFormat(finalStat.statValue)
                    )
                }

                "상태이상 내성" -> {
                    result[7] = CharacterUiState.CharacterEtcStat(
                        "상태이상 내성",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "이동속도" -> {
                    result[8] = CharacterUiState.CharacterEtcStat(
                        "이동속도",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "점프력" -> {
                    result[9] = CharacterUiState.CharacterEtcStat(
                        "점프력",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "스탠스" -> {
                    result[10] = CharacterUiState.CharacterEtcStat(
                        "스탠스",
                        PowerFormatConverter.convertPercentFormat(finalStat.statValue)
                    )
                }

                "공격 속도" -> {
                    result[11] = CharacterUiState.CharacterEtcStat(
                        "공격 속도",
                        PowerFormatConverter.convertAttackSpeedFormat(finalStat.statValue)
                    )
                }
            }
        }

        return result
    }
}