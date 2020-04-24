package ua.rolinskiy.counter.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ua.rolinskiy.counter.model.Counter

@Database(version = 1, entities = [Counter::class], exportSchema = false)
abstract class CounterRoomDatabase : RoomDatabase() {
    abstract fun countersDao(): CountersDao

    companion object {
        @Volatile
        private var INSTANCE: CounterRoomDatabase? = null

        fun getDatabase(context: Context): CounterRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CounterRoomDatabase::class.java,
                    "counter_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}