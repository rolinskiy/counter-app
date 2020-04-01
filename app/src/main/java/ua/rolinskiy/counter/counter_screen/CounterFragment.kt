package ua.rolinskiy.counter.counter_screen

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import ua.rolinskiy.counter.R
import ua.rolinskiy.counter.databinding.CounterFragmentBinding

class CounterFragment : Fragment() {

    companion object {
        fun newInstance() = CounterFragment()
    }

    private val vm: CounterViewModel by viewModel()

    private val vibrator by lazy {
        context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return DataBindingUtil.inflate<CounterFragmentBinding>(
            inflater,
            R.layout.counter_fragment, container, false
        ).apply {
            viewModel = vm
            lifecycleOwner = this@CounterFragment
            buttonPlus.setOnClickListener {
                vm.onIncrementButtonClick()
                @Suppress("DEPRECATION")
                vibrator?.vibrate(30)
            }
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.initCounter()


    }

}
