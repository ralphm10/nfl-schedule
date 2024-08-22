package com.ralph.nflschedule

data class ScheduleResponse(val body: Schedule?)

data class Schedule(val schedule: List<Game>?)

data class Game(val gameStatus: String, val home: String, val away: String, val gameDate: String)
