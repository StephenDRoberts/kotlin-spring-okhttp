package com.example.httprequest

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class Repository(){

    @PostConstruct
    fun makeRequest() {
        val okHttpClient = OkHttpClient()
        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest()).execute())

        println(parsedResponse)
    }

    fun createRequest(): Request {
        return Request.Builder()
                .url("https://www.api-football.com/demo/api/v2/leagues/league/524")
                .build()
    }

    fun parseResponse(response: Response): String {
        val body = response.body?.string() ?: ""
        return body
    }

}