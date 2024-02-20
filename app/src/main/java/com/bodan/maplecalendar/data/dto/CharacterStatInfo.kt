package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep

@Keep
data class CharacterStatInfo(
    val characterStat: String = "",
    var characterPower: String = "",
    var characterStr: String = "",
    var characterDex: String = "",
    var characterInt: String = "",
    var characterLuk: String = "",
    var characterHp: String = "",
    var characterMp: String = "",
    var characterStatPower: String = "",
    var characterDamage: String = "",
    var characterFinalDamage: String = "",
    var characterBossDamage: String = "",
    var characterIgnoreMonsterArmor: String = "",
    var characterNormalDamage: String = "",
    var characterAttackPower: String = "",
    var characterCriticalRate: String = "",
    var characterMagicPower: String = "",
    var characterCriticalDamage: String = "",
    var characterCooltimeReduceSec: String = "",
    var characterCooltimeReducePercent: String = "",
    var characterBuffPersistTime: String = "",
    var characterCooltimeCancel: String = "",
    var characterIgnoreElementResist: String = "",
    var characterCrowdControlDamage: String = "",
    var characterSummonTimeIncrease: String = "",
    var characterMesoDrop: String = "",
    var characterStarforce: String = "",
    var characterItemDrop: String = "",
    var characterArcaneForce: String = "",
    var characterExpUp: String = "",
    var characterAuthenticForce: String = "",
    var characterArmor: String = "",
    var characterCrowdControlResist: String = "",
    var characterSpeed: String = "",
    var characterJump: String = "",
    var characterStance: String = "",
    var characterAttackSpeed: String = ""
)