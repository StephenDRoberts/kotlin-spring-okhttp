package com.example.httprequest

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Repository

@EnableScheduling
@Repository
class Repository(){

    @Scheduled(initialDelay = 0, fixedDelay = 24*60*60*1000)
    fun makeRequest() {
        val okHttpClient = OkHttpClient()
        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest()).execute())

        println(parsedResponse)
    }

    fun createRequest(): Request {
        return Request.Builder()
                .url("https://www.api-football.com/demo/api/v2/teams/league/524")
                .build()
    }

    fun parseResponse(response: Response): String {
        val body = response.body?.string() ?: ""
        return body
    }

}
