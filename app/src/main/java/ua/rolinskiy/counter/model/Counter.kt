package ua.rolinskiy.counter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counters_table")
class Counter(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name", defaultValue = "Counter") var name: String,
    @ColumnInfo(name = "value", defaultValue = "0") var value: Int
)

