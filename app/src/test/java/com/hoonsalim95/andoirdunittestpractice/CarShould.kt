package com.hoonsalim95.andoirdunittestpractice


import com.hoonsalim95.andoirdunittestpractice.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class CarShould {
    var engine: Engine = mock(Engine::class.java) //타입 추론으로 Mock 객체 생성
//    private val engine = Engine()
    private val car = Car(engine,5.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runTest {
        car.turnOn()
        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(6001)

        verify(engine, times(1)).turnOn()       //verity 함수는 원하는 상호작용이 있었는가 검증. 메서드 호출, 필드 참조가 있었는가 확인 시 사용.

//        verify(engine, never()).turnOn()                        //verity 의 never 함수는 호출되지 않았을 경우 통과
//
//        verify(engine, atLeastOnce()).turnOn()                        //verity 의 atLeastOnce 최소 한번은 호출 되었는가
//        verify(engine, atLeast(2)).turnOn()                        //verity 의 atLeastOnce 최소 2번은 호출 되었는가
//
//        verify(engine, atMost(2)).turnOn()                        //verity 의 atMost 최대 3번은 호출 되었는가
//
//        verify(engine, only()).turnOn()                        //verity 의 only 오직 해당 함수만 호출 되었는가.
    }
}