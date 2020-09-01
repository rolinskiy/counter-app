package ua.rolinskiy.counter.counter_screen

import android.app.Application
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import ua.rolinskiy.counter.model.Counter
import ua.rolinskiy.counter.model.decrement
import ua.rolinskiy.counter.model.increment
import ua.rolinskiy.counter.model.reset

class CounterViewModel(application: Application) : AndroidViewModel(application), KoinComponent {

    private val repository: CounterRepository by inject()
    private val vibrator: Vibrator? by inject()

    val counterText: LiveData<String>
        get() = _counterText
    private val _counterText = MutableLiveData<String>()

    lateinit var counter: Counter

    fun initCounter(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            counter = repository.getCounter(id)
            if (counter == null) {
                counter = Counter(id, "Counter", 0)
                repository.createCounter(counter)
            }
            updateCounterUI()
        }
    }

    fun saveCounter() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCounter(counter)
        }
    }

    fun onIncrementButtonClick(v: View) {
        increment()
    }

    fun onDecrementButtonClick(v: View) {
        decrement()
    }

    fun onResetButtonClick(v: View) {
        counter.reset()
        updateCounterUI()
    }

    fun onLockButtonClick(v: View) {
        //todo lock all buttons but increment
    }

    fun increment() {
        counter.increment()
        updateCounterUI()
        vibrateIncrement()
    }

    fun decrement() {
        counter.decrement()
        updateCounterUI()
        vibrateDecrement()
    }

    private fun updateCounterUI() {
        val countText = String.format("%04d", counter.value)
        _counterText.postValue(countText)
    }

    private fun vibrateIncrement() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator?.vibrate(VibrationEffect.createOneShot(30, 3))
        } else {
            vibrator?.vibrate(30)
        }
    }

    private fun vibrateDecrement() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator?.vibrate(VibrationEffect.createOneShot(30, 3))
            vibrator?.vibrate(VibrationEffect.createOneShot(30, 3))
        } else {
            vibrator?.vibrate(30)
            vibrator?.vibrate(30)
        }
    }

}
