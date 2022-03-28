package com.example.chanofresponsabilityexample.domain.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Director : Approver() {

    override suspend fun process(c: Operation) {
        if( c.amount <= 1000 ){
            Log.d("CHAIN","La compra fue aprobada por el Director")
        }else{
            Log.d("CHAIN","La compra debe ser aprobada por el consejo directivo")
        }
    }
}