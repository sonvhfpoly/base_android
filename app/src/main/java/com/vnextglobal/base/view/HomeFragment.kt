package com.vnextglobal.base.view

import androidx.fragment.app.viewModels
import com.vnextglobal.base.databinding.FragmentHomeBinding
import com.vnextglobal.base.viewmodel.HomeViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseBindingFragment<FragmentHomeBinding>() {

    private val vm:HomeViewModel by viewModels()

    override fun init() {
        val user = vm.getUserInfo()
        binding.tvUsername.text = user.firstName + user.lastName
    }

}