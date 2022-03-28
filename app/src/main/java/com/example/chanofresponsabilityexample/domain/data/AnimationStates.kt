package com.example.chanofresponsabilityexample.domain.data

sealed class AnimationStates {
    object BeginProcess : AnimationStates()
    object RequestPreAuth : AnimationStates()
    object EndProcess : AnimationStates()
}