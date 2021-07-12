package com.dsilvera.kotlinarchitecture.presentation.common.extension

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dsilvera.kotlinarchitecture.R

fun Fragment.mainNavController() = requireActivity().findNavController(R.id.nav_host_fragment)