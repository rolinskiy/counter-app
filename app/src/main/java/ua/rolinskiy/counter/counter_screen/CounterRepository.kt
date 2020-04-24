package ua.rolinskiy.counter.counter_screen

import androidx.lifecycle.LiveData
import ua.rolinskiy.counter.model.Counter

interface CounterRepository {

    suspend fun getCounter(id: Int): Counter

    suspend fun getCounter(name: String): Counter

    suspend fun getAllCounters(): LiveData<List<Counter>>

    suspend fun updateCounter(counter: Counter)

    suspend fun createCounter(counter: Counter)

    suspend fun createDefaultCounter()

    suspend fun deleteCounter(counter: Counter)

}