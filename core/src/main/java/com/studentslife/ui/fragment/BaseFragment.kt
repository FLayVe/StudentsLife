package com.studentslife.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.studentslife.ui.stream.BottomNavMenuStream
import com.studentslife.ui.viewModel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    protected lateinit var factory: ViewModelFactory

    @Inject
    lateinit var bottomNavMenuStream: BottomNavMenuStream

    protected fun showToastMessage(text: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(requireContext(), text, duration).show()
    }

    open fun getBottomNavMenuVisibility(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavMenuStream.post(getBottomNavMenuVisibility())
    }
}