package com.example.httprequest

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Repository

val objectMapper = jacksonObjectMapper()

@EnableScheduling
@Repository
class Repository(){

    @Scheduled(initialDelay = 0, fixedDelay = 24*60*60*1000)
    fun makeRequest() {
        val okHttpClient = OkHttpClient()
        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest()).execute())
        println(parsedResponse.api.teams.first().name)
    }

    fun createRequest(): Request {
        return Request.Builder()
                .url("https://www.api-football.com/demo/api/v2/teams/league/524")
                .build()
    }

    fun parseResponse(response: Response): DTO {
        val body = response.body?.string() ?: ""
        val jsonBody = objectMapper.readValue<DTO>(body)
        return jsonBody
    }
}
