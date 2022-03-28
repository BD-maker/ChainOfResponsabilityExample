package com.example.chanofresponsabilityexample.core

import com.example.chanofresponsabilityexample.domain.data.SdkEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object EventBus {
    
    private val _events = MutableSharedFlow<SdkEvent>()
    val events = _events.asSharedFlow()

    suspend fun invokeEvent(event: SdkEvent) = _events.emit(event)

}