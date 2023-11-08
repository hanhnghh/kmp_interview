package com.example.myapplication.view_model

import com.example.myapplication.data.model.TeamModel
import com.example.myapplication.data.repository.PocRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class PocViewModel (private val pocRepository: PocRepository): ViewModel(){
    private val _teamDataState = MutableStateFlow<List<TeamModel>>(listOf())
    val teamDataState: StateFlow<List<TeamModel>> = _teamDataState

    init {
        viewModelScope.launch {
            pocRepository.getTeams().flowOn(Dispatchers.IO)
                .distinctUntilChanged()
                .collectLatest { teamData ->
                    _teamDataState.value = teamData.teams
                }
        }
    }

}