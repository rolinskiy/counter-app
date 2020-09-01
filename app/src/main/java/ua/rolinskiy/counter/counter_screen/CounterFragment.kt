package ua.rolinskiy.counter.counter_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.sharedViewModel
import ua.rolinskiy.counter.R
import ua.rolinskiy.counter.databinding.CounterFragmentBinding

//TODO add TARGET count
//TODO add TARGET reached vibration
//TODO add TARGET reached times statistics
//TODO add "Counters list" button and screen

class CounterFragment : Fragment() {
    private val defaultId = 1

    companion object {
        private const val KEY_COUNTER_ID = "KEY_COUNTER_ID"
        fun newInstance(id: Int?) = CounterFragment().apply {
            id?.let {
                arguments = Bundle().apply {
                    putInt(KEY_COUNTER_ID, id)
                }
            }
        }
    }

    private val vm: CounterViewModel by sharedViewModel()

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
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val counterId = arguments?.getInt(KEY_COUNTER_ID) ?: defaultId
        vm.initCounter(counterId)
    }

    override fun onPause() {
        super.onPause()
        vm.saveCounter()
    }

}
