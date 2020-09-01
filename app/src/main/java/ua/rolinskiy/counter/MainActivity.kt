package ua.rolinskiy.counter

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel
import ua.rolinskiy.counter.counter_screen.CounterViewModel

class MainActivity : AppCompatActivity() {
    private val counterVm: CounterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean = when (keyCode) {
        KeyEvent.KEYCODE_VOLUME_UP -> true
        KeyEvent.KEYCODE_VOLUME_DOWN -> true
        else -> super.onKeyUp(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean = when (keyCode) {
        KeyEvent.KEYCODE_VOLUME_UP -> {
            counterVm.increment()
            true
        }
        KeyEvent.KEYCODE_VOLUME_DOWN -> {
            counterVm.decrement()
            true
        }
        else -> super.onKeyUp(keyCode, event)
    }
}
