package com.ralph.nflschedule

import jakarta.annotation.Nonnull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ScheduleController(val scheduleService: ScheduleService) {

    @GetMapping("/test")
    fun test(): String = "Test endpoint!"

    @GetMapping("/schedule")
    fun getSchedule(@RequestParam("team") @Nonnull teamCode: String): Mono<String> {
        return scheduleService.getSchedule(teamCode)
    }

    @GetMapping("/teams")
    fun getTeams(): String {
        return "team info"
    }
}