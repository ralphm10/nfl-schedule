package com.ralph.nflschedule

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun formatDate(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val date = LocalDate.parse(dateString, formatter)
    return date.format(DateTimeFormatter.ofPattern("EEEE dd-MM-YY"))
}