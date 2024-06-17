package com.bodan.maplecalendar.data.mapper

import com.bodan.maplecalendar.data.model.AndroidEntity
import com.bodan.maplecalendar.domain.entity.CharacterAndroid
import com.bodan.maplecalendar.domain.entity.CharacterAndroidFace
import com.bodan.maplecalendar.domain.entity.CharacterAndroidHair
import com.bodan.maplecalendar.domain.entity.CharacterAndroidInfo

object CharacterAndroidMapper {

    operator fun invoke(androidEntity: AndroidEntity): CharacterAndroid {
        val androids = mutableListOf<CharacterAndroidInfo?>()

        if (androidEntity.androidFirstPreset != null) {
            androids.add(
                CharacterAndroidInfo(
                    androidName = androidEntity.androidFirstPreset.androidName,
                    androidNickname = androidEntity.androidFirstPreset.androidNickname,
                    androidIcon = androidEntity.androidFirstPreset.androidIcon,
                    androidDescription = androidEntity.androidFirstPreset.androidDescription,
                    androidGender = androidEntity.androidFirstPreset.androidGender,
                    androidGrade = androidEntity.androidFirstPreset.androidGrade,
                    androidSkinName = androidEntity.androidFirstPreset.androidSkinName,
                    androidHair = CharacterAndroidHair(
                        hairName = androidEntity.androidFirstPreset.androidHair.hairName,
                        baseColor = androidEntity.androidFirstPreset.androidHair.baseColor,
                        mixColor = androidEntity.androidFirstPreset.androidHair.mixColor,
                        mixRate = androidEntity.androidFirstPreset.androidHair.mixRate
                    ),
                    androidFace = CharacterAndroidFace(
                        faceName = androidEntity.androidFirstPreset.androidFace.faceName,
                        baseColor = androidEntity.androidFirstPreset.androidFace.baseColor,
                        mixColor = androidEntity.androidFirstPreset.androidFace.mixColor,
                        mixRate = androidEntity.androidFirstPreset.androidFace.mixRate
                    ),
                    androidEarSensorClipFlag = androidEntity.androidFirstPreset.androidEarSensorClipFlag,
                    androidNonHumanoidFlag = androidEntity.androidFirstPreset.androidNonHumanoidFlag,
                    androidShopUsableFlag = androidEntity.androidFirstPreset.androidShopUsableFlag
                )
            )
        } else {
            androids.add(null)
        }

        if (androidEntity.androidSecondPreset != null) {
            androids.add(
                CharacterAndroidInfo(
                    androidName = androidEntity.androidSecondPreset.androidName,
                    androidNickname = androidEntity.androidSecondPreset.androidNickname,
                    androidIcon = androidEntity.androidSecondPreset.androidIcon,
                    androidDescription = androidEntity.androidSecondPreset.androidDescription,
                    androidGender = androidEntity.androidSecondPreset.androidGender,
                    androidGrade = androidEntity.androidSecondPreset.androidGrade,
                    androidSkinName = androidEntity.androidSecondPreset.androidSkinName,
                    androidHair = CharacterAndroidHair(
                        hairName = androidEntity.androidSecondPreset.androidHair.hairName,
                        baseColor = androidEntity.androidSecondPreset.androidHair.baseColor,
                        mixColor = androidEntity.androidSecondPreset.androidHair.mixColor,
                        mixRate = androidEntity.androidSecondPreset.androidHair.mixRate
                    ),
                    androidFace = CharacterAndroidFace(
                        faceName = androidEntity.androidSecondPreset.androidFace.faceName,
                        baseColor = androidEntity.androidSecondPreset.androidFace.baseColor,
                        mixColor = androidEntity.androidSecondPreset.androidFace.mixColor,
                        mixRate = androidEntity.androidSecondPreset.androidFace.mixRate
                    ),
                    androidEarSensorClipFlag = androidEntity.androidSecondPreset.androidEarSensorClipFlag,
                    androidNonHumanoidFlag = androidEntity.androidSecondPreset.androidNonHumanoidFlag,
                    androidShopUsableFlag = androidEntity.androidSecondPreset.androidShopUsableFlag
                )
            )
        } else {
            androids.add(androids[0])
        }

        if (androidEntity.androidThirdPreset != null) {
            androids.add(
                CharacterAndroidInfo(
                    androidName = androidEntity.androidThirdPreset.androidName,
                    androidNickname = androidEntity.androidThirdPreset.androidNickname,
                    androidIcon = androidEntity.androidThirdPreset.androidIcon,
                    androidDescription = androidEntity.androidThirdPreset.androidDescription,
                    androidGender = androidEntity.androidThirdPreset.androidGender,
                    androidGrade = androidEntity.androidThirdPreset.androidGrade,
                    androidSkinName = androidEntity.androidThirdPreset.androidSkinName,
                    androidHair = CharacterAndroidHair(
                        hairName = androidEntity.androidThirdPreset.androidHair.hairName,
                        baseColor = androidEntity.androidThirdPreset.androidHair.baseColor,
                        mixColor = androidEntity.androidThirdPreset.androidHair.mixColor,
                        mixRate = androidEntity.androidThirdPreset.androidHair.mixRate
                    ),
                    androidFace = CharacterAndroidFace(
                        faceName = androidEntity.androidThirdPreset.androidFace.faceName,
                        baseColor = androidEntity.androidThirdPreset.androidFace.baseColor,
                        mixColor = androidEntity.androidThirdPreset.androidFace.mixColor,
                        mixRate = androidEntity.androidThirdPreset.androidFace.mixRate
                    ),
                    androidEarSensorClipFlag = androidEntity.androidThirdPreset.androidEarSensorClipFlag,
                    androidNonHumanoidFlag = androidEntity.androidThirdPreset.androidNonHumanoidFlag,
                    androidShopUsableFlag = androidEntity.androidThirdPreset.androidShopUsableFlag
                )
            )
        } else {
            androids.add(androids[0])
        }

        return CharacterAndroid(androids = androids)
    }
}