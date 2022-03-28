package com.example.chanofresponsabilityexample.domain.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Buyer : Approver() {

    override suspend fun process(c: Operation) {
        if( c.amount <= 100){
            Log.d("CHAIN","La compra fue aprobada por el comprador")
        }else{
            next?.let{it.process(c)}
        }
    }
}