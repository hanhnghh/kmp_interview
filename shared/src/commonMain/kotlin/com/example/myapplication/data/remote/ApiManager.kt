package com.example.myapplication.data.remote

import com.example.myapplication.data.model.TeamData
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class ApiManager {

    private val client = HttpClient()

    suspend fun getTeams(): TeamData {
        val response = client.get("https://jmde6xvjr4.execute-api.us-east-1.amazonaws.com/teams")
        return Json.decodeFromString(response.bodyAsText())
    }
}