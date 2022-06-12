package com.hoonsalim95.andoirdunittestpractice

import android.util.Log
import kotlinx.coroutines.delay

class Engine (
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15,
){
    companion object{
        public val TAG = Engine::class.java.simpleName
    }

    suspend fun turnOn(){
        isTurnedOn = true

//        Thread.sleep(6000)      //메인쓰레드 블락됨.
        delay(6000)      //쓰레드 블락 되지 않음.
        temperature = 95

        Log.d(TAG, "turnOn: 엔진 on")
    }

//    fun turnOff(){
//        isTurnedOn = false
//        temperature = 15
//    }
}