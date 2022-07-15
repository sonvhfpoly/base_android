package com.vnextglobal.base.view

import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.vnextglobal.aframework.xml.BaseBindingFragment
import com.vnextglobal.aframework.xml.BaseNavigationFragment
import com.vnextglobal.base.databinding.FragmentMovieDetailBinding
import com.vnextglobal.base.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment: BaseNavigationFragment<FragmentMovieDetailBinding>() {
    private val vm: MovieDetailViewModel by viewModels()
    val args: MovieDetailFragmentArgs by navArgs()
    override fun init() {
        requireActivity().setTitle(args.movieTitle)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                val movieDetail = vm.getMovieDetail(args.movieId)
                val backdrop = vm.getMovieBackdropImages(args.movieId).map {backdrop ->
                    SlideModel(backdrop.getImageUrlPath())
                }
                binding.imageSlider.setImageList(backdrop, ScaleTypes.FIT)
                binding.tvMovieDesc.text = movieDetail.overview
            }
        }
    }
}