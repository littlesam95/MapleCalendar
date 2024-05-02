package com.bodan.maplecalendar.domain.entity

import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.app.MainApplication
import java.util.UUID

data class EventItem(
    val eventId: UUID = UUID.randomUUID(),
    val eventName: String,
    val eventIat: String,
    val eventExp: String,
    val eventType: List<EventType>,
    val eventUrl: String,
    val eventImage: String
)

enum class EventType(val backgroundColor: Int, val textColor: Int, val tag: String) {
    PCROOM(
        R.color.power_background,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_pc_room)
    ),
    DAYCHECK(
        R.color.submit,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_day_check)
    ),
    MINIGAME(
        R.color.power_title,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_mini_game)
    ),
    SPECIALSTAT(
        R.color.equipment_rare,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_special_stat)
    ),
    BURNING(
        R.color.equipment_etc_option_minus,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_burning)
    ),
    COINSHOP(
        R.color.equipment_soul,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_coinshop)
    ),
    CASH(
        R.color.equipment_title,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_cash)
    ),
    WORLDLEAP(
        R.color.nickname,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_world_leap)
    ),
    EVENTWORLD(
        R.color.equipment_epic,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_event_world)
    ),
    HUNTING(
        R.color.power_color,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_hunting)
    ),
    PUNCHKING(
        R.color.guild,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_punch_king)
    ),
    BOSS(
        R.color.stat_background2,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_boss)
    ),
    COORDINATE(
        R.color.equipment_legendary,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_coordinate)
    ),
    SPECIALSUNDAY(
        R.color.equipment_starforce_option,
        R.color.black,
        MainApplication.myContext().resources.getString(R.string.text_tag_special_sunday)
    ),
    DEFAULT(
        R.color.main,
        R.color.white,
        MainApplication.myContext().resources.getString(R.string.text_tag_default)
    )
}