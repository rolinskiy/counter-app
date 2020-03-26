package ua.rolinskiy.counter.counter_screen

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val counterText: LiveData<String>
        get() = _counterText
    private val _counterText = MutableLiveData<String>()

    var counter = 0
        set(value) {
            field = value
            updateCounter()
        }

    fun initCounter() {
        counter = 0
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
        initCounter()
    }

    fun onLockButtonClick(v: View) {
        //todo lock all buttons but increment
    }

    private fun updateCounter() {
        val countText = String.format("%04d", counter)
        _counterText.postValue(countText)
    }

}
