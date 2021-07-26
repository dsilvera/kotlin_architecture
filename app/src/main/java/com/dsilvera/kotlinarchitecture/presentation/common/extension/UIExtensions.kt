package com.dsilvera.kotlinarchitecture.presentation.common.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.dsilvera.kotlinarchitecture.R
import kotlinx.coroutines.Dispatchers

fun ViewModel.contextIO() = viewModelScope.coroutineContext + Dispatchers.IO

fun Fragment.mainNavController() = requireActivity().findNavController(R.id.nav_host_fragment)