package com.hoonsalim95.andoirdunittestpractice

import com.hoonsalim95.andoirdunittestpractice.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.advanceTimeBy
import org.junit.Rule
import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(engine, 6.0, )

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn(){
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnTiEngineAndIncreaseTheTemperature(){
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(6001)
        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }
}