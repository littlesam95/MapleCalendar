package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterAndroidInfo(
    val androidName: String,
    val androidNickname: String,
    val androidIcon: String,
    val androidDescription: String,
    val androidGender: String,
    val androidGrade: String,
    val androidSkinName: String?,
    val androidHair: CharacterAndroidHair,
    val androidFace: CharacterAndroidFace,
    val androidEarSensorClipFlag: String,
    val androidNonHumanoidFlag: String,
    val androidShopUsableFlag: String
)