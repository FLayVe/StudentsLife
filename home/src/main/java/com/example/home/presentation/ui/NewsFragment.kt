package com.example.home.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.databinding.FragmentNewsBinding
import com.example.home.presentation.ui.adapter.NewsRecyclerAdapter
import com.example.home.presentation.viewModel.NewsViewModel
import com.studentslife.ui.fragment.BaseFragment

class NewsFragment: BaseFragment() {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsBinding.inflate(inflater, container, false).apply {
            viewModel = this@NewsFragment.viewModel
            lifecycleOwner = this@NewsFragment
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNews()

        viewModel.events.observe(viewLifecycleOwner){
            when (it) {
                is NewsViewModel.Event.ShowToast
                -> showToastMessage(it.text)
                is NewsViewModel.Event.OnError
                -> Log.e(NewsViewModel::class.java.name, "${it.throwable.message}")
            }
        }
    }

}