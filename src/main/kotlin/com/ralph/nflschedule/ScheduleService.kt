package com.ralph.nflschedule

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.time.Year

private const val HOST = "tank01-nfl-live-in-game-real-time-statistics-nfl.p.rapidapi.com"
private const val PATH = "getNFLTeamSchedule"

@Service
class ScheduleService(private val webClient: WebClient) {
    fun getNextGame(teamCode: String): String {
        val scheduleResponseMono = makeScheduleRequest(teamCode)

        val scheduleList = scheduleResponseMono.block()?.schedule() ?: emptyList()
        val nextGame = scheduleList.first { it.gameStatus == "Scheduled" }
        return formatGame(nextGame)
    }

    private fun formatGame(game: Game) =
        "The next ${game.seasonType} game is ${game.away} @ ${game.home} on ${formatDate(game.gameDate)}"

    private fun makeScheduleRequest(teamCode: String): Mono<ScheduleResponse> {
        return webClient.get()
            .uri {
                it.scheme("https")
                    .host(HOST)
                    .path(PATH)
                    .queryParam("teamAbv", teamCode)
                    .queryParam("season", Year.now())
                    .build()
            }
            .header("x-rapidapi-host", HOST)
            .header("x-rapidapi-key", System.getenv("NFL_API_KEY"))
            .retrieve()
            .bodyToMono(ScheduleResponse::class.java)
    }
}