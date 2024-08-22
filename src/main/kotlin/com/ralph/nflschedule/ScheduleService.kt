package com.ralph.nflschedule

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

private const val HOST = "tank01-nfl-live-in-game-real-time-statistics-nfl.p.rapidapi.com"
private const val PATH = "getNFLTeamSchedule"

@Service
class ScheduleService(private val webClient: WebClient) {
    fun getNextGame(teamCode: String): Game {
        val scheduleResponseMono = makeScheduleRequest(teamCode)

        val scheduleList = scheduleResponseMono.block()?.body?.schedule ?: emptyList()
        return scheduleList.first { game: Game -> game.gameStatus == "Scheduled" }
    }

    private fun makeScheduleRequest(teamCode: String): Mono<ScheduleResponse> {
        val scheduleResponseMono = webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .scheme("https")
                    .host(HOST)
                    .path(PATH)
                    .queryParam("teamAbv", teamCode)
                    .queryParam("season", "2024")
                    .build()
            }
            .header("x-rapidapi-host", HOST)
            .header("x-rapidapi-key", System.getenv("NFL_API_KEY"))
            .retrieve()
            .bodyToMono(ScheduleResponse::class.java)
        return scheduleResponseMono
    }
}