package com.ralph.nflschedule

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScheduleController{

    @GetMapping("/test")
    fun test(): String = "Test endpoint!"
}