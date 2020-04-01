package ua.rolinskiy.counter.counter_screen

interface CounterRepository {

    fun getCounterValue(): Int
    fun getCounterName(): String

}