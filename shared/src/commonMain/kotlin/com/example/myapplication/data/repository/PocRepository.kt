package com.example.myapplication.data.repository

import com.example.myapplication.data.model.TeamData
import com.example.myapplication.data.remote.ApiManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PocRepository(private val apiManager: ApiManager) {

    suspend fun getTeams(): Flow<TeamData> = flow {
        emit(apiManager.getTeams())
    }
}