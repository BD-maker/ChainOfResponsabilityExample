package com.example.chanofresponsabilityexample.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chanofresponsabilityexample.core.ContactlessPayListener
import com.example.chanofresponsabilityexample.core.EventBus
import com.example.chanofresponsabilityexample.domain.data.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class CompraViewModel: ViewModel() {

    private val _states = MutableLiveData<AnimationStates>()
    val states : LiveData<AnimationStates> = _states

    fun init(){

        // Definimos actores de la cadena
        val store = Store()
        val buyer = Buyer()
        val manager = Manager()
        val director = Director()

        // Definición de responsabilidades
        store.addNext(buyer)
        buyer.addNext(manager)
        manager.addNext(director)

        // operaciones

        viewModelScope.launch{

            _states.value = AnimationStates.BeginProcess

            delay(10)
            store.process(Operation(amount = 100))

            store.process(Operation(amount = 400))

            store.process(Operation(amount = 900))

            store.process(Operation(amount = 2000))
            delay(10)

            _states.postValue(AnimationStates.RequestPreAuth)

            // Suscribimos al evento preAuthCompleted
            EventBus.events.filter { event -> event == SdkEvent.preAuthCompleted }
                .collectLatest { readyToTap() }
        }
    }

    fun readyToTap(){
        Log.d("ViewModel", "Listo para ser abonado")
    }
}