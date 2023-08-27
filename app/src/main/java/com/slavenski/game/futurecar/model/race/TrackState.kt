package com.slavenski.game.futurecar.model.race

sealed class TrackState {
    object GameOver : TrackState()
    object PrepareStart : TrackState()
    object ProcessRace : TrackState()
}