package com.example.chanofresponsabilityexample.domain.data

sealed class SdkEvent {
    object preAuthCompleted : SdkEvent()
}