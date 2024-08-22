package com.ralph.nflschedule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NflScheduleApplication

fun main(args: Array<String>) {
    runApplication<NflScheduleApplication>(*args)
}
