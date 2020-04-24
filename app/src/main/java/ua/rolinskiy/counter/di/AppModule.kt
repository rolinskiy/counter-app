package ua.rolinskiy.counter.di

import android.app.Application
import android.content.Context
import android.os.Vibrator
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ua.rolinskiy.counter.counter_screen.CounterRepository
import ua.rolinskiy.counter.counter_screen.CounterRepositoryImpl
import ua.rolinskiy.counter.counter_screen.CounterViewModel
import ua.rolinskiy.counter.room.CounterRoomDatabase

val appModule = module {
    viewModel { CounterViewModel(get()) }

    single { CounterRoomDatabase.getDatabase(get()) }

    single { get<CounterRoomDatabase>().countersDao() }

    single<CounterRepository> { CounterRepositoryImpl(get()) }

    single {
        get<Application>().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
    }

}