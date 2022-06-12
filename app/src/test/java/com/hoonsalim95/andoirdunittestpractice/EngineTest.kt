package com.hoonsalim95.andoirdunittestpractice

import com.hoonsalim95.andoirdunittestpractice.utils.MainCoroutineScopeRule
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class EngineTest {
    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun engineTurnOn() = runTest {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)
        assertEquals(95, engine.temperature)
    }


    @Test
    fun engineTurnOff() = runTest {
        engine.turnOn()

//        engine.turnOff()
//
//        assertEquals(true, engine.isTurnedOn)
//        assertEquals(15, engine.temperature)
    }
}