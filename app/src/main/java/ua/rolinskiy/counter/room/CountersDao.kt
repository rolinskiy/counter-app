package ua.rolinskiy.counter.room

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.rolinskiy.counter.model.Counter

@Dao
interface CountersDao {

    @Query("SELECT * from counters_table")
    fun getAllCounters(): LiveData<List<Counter>>

    @Query("SELECT * from counters_table where id = :id LIMIT 1")
    fun getCounter(id: Int): Counter

    @Query("SELECT * from counters_table where name = :name LIMIT 1")
    fun getCounter(name: String): Counter

    @Insert(entity = Counter::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertCounter(counter: Counter)

    @Query("INSERT INTO counters_table DEFAULT VALUES")
    fun createDefaultCounter()

    @Update
    fun updateCounter(counter: Counter)

    @Delete
    fun deleteCounter(counter: Counter)

}
