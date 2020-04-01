package ua.rolinskiy.counter.counter_screen

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel(val repository: CounterRepository) : ViewModel() {

    val counterText: LiveData<String>
        get() = _counterText
    private val _counterText = MutableLiveData<String>()

    var counter = 0
        set(value) {
            field = value
            updateCounter()
        }

    fun initCounter() {
        counter = repository.getCounterValue()
    }

    fun onIncrementButtonClick() {
        counter++
    }

    fun onDecrementButtonClick(v: View) {
        if (counter > 0) {
            counter--
        }
    }

    fun onResetButtonClick(v: View) {
        counter = 0
    }

    fun onLockButtonClick(v: View) {
        //todo lock all buttons but increment
    }

    private fun updateCounter() {
        val countText = String.format("%04d", counter)
        _counterText.postValue(countText)
    }

}
