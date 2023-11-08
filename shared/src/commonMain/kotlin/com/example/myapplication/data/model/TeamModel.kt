package com.example.myapplication.data.model

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamData(
    @SerialName("teams") val teams: List<TeamModel>

)

@Serializable
data class TeamModel(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("logo") val logo: String

)


