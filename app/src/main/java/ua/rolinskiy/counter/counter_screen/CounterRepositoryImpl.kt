package ua.rolinskiy.counter.counter_screen

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import ua.rolinskiy.counter.model.Counter
import ua.rolinskiy.counter.room.CountersDao

class CounterRepositoryImpl(private val dao: CountersDao) : CounterRepository {

    @WorkerThread
    override suspend fun getAllCounters(): LiveData<List<Counter>> = dao.getAllCounters()

    @WorkerThread
    override suspend fun getCounter(id: Int): Counter = dao.getCounter(id)

    @WorkerThread
    override suspend fun getCounter(name: String): Counter = dao.getCounter(name)

    @WorkerThread
    override suspend fun updateCounter(counter: Counter) = dao.updateCounter(counter)

    @WorkerThread
    override suspend fun createCounter(counter: Counter) = dao.insertCounter(counter)

    @WorkerThread
    override suspend fun createDefaultCounter() = dao.createDefaultCounter()

    @WorkerThread
    override suspend fun deleteCounter(counter: Counter) = dao.deleteCounter(counter)

}