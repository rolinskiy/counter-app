package ua.rolinskiy.counter.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ua.rolinskiy.counter.counter_screen.CounterRepositoryImpl
import ua.rolinskiy.counter.counter_screen.CounterViewModel

val appModule = module {
    viewModel { CounterViewModel(get()) }

    single { CounterRepositoryImpl() }

}