package com.example.chanofresponsabilityexample.core

import com.example.chanofresponsabilityexample.domain.data.SdkEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactlessPayListener {

    fun onAuthenticationCompleted(){
        CoroutineScope(Dispatchers.Main).launch {
            EventBus.invokeEvent(SdkEvent.preAuthCompleted)
        }
    }
}