package com.example.httprequest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class DTO(val api: ApiResponse)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApiResponse(
        val results: Int,
        val teams: List<Team>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Team(
        val team_id: Int,
        val name: String,
        val country: String,
        val venue_name: String
)
