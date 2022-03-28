package com.example.chanofresponsabilityexample.domain.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Store : Approver() {

    override suspend fun process(c: Operation) {

        Log.d("CHAIN","Ingresó una compra por ${c.amount}")
        next?.let{it.process(c)}
    }
}