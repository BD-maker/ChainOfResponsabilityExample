package com.example.chanofresponsabilityexample.domain.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Manager : Approver() {

    override suspend fun process(c: Operation) {
        if( c.amount <= 500 ){
            Log.d("CHAIN","La compra fue aprobada por el Manager")
        }else{
            next?.let{it.process(c)}
        }
    }
}