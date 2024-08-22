package com.ralph.nflschedule

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ScheduleController(val scheduleService: ScheduleService) {

    @GetMapping("/test")
    fun test(): String = "Test endpoint!"

    @GetMapping("/schedule")
    fun getSchedule(): Mono<String> {
        return scheduleService.getSchedule()
    }

    @GetMapping("/teams")
    fun getTeams(): String {
        return "team info"
    }
}