package com.vnextglobal.base.view

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.vnextglobal.aframework.xml.BaseBindingFragment
import com.vnextglobal.base.databinding.FragmentHomeBinding
import com.vnextglobal.base.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment: BaseBindingFragment<FragmentHomeBinding>() {

    private val vm:HomeViewModel by viewModels()
    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter()
    }

    override fun init() {
//        val user = vm.getUserInfo()
//        binding.tvUsername.text = user.firstName + user.lastName

//        viewLifecycleOwner.lifecycleScope.launch {
//            val movieList = vm.getRecommendedMovies()
//            val moviesNameJoinStr = movieList.map {
//                it.title
//            }.joinToString()
//            binding.tvUsername.text = moviesNameJoinStr
//        }
        binding.rcvMovieList.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            vm.getRecommendedMoviesFlow().collectLatest {
                adapter.submitData(it)
            }
        }
    }

}