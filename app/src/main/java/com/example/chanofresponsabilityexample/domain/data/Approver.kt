package com.example.chanofresponsabilityexample.domain.data


abstract class Approver {

    var next : Approver? = null

    fun addNext(approver: Approver){
        next = approver
    }

    abstract suspend fun process(c: Operation)
}