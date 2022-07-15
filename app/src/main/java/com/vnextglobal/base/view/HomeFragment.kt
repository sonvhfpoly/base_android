package com.vnextglobal.base.view

import android.content.Intent
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.vnextglobal.aframework.xml.BaseNavigationFragment
import com.vnextglobal.base.R
import com.vnextglobal.base.databinding.FragmentHomeBinding
import com.vnextglobal.base.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseNavigationFragment<FragmentHomeBinding>() {

    private val vm: HomeViewModel by activityViewModels()
    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter { movie ->
            if (movie.id != null) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                        movie.id!!,
                        movie.title
                    )
                )
            }
        }
    }

    override fun init() {
        binding.rcvMovieList.adapter = adapter
        requireActivity().setTitle(getString(R.string.app_name))
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                vm.uiState.collectLatest {
                    adapter.submitData(it)
                }
            }

        }
    }

}