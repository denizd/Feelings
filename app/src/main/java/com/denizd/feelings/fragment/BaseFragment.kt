package com.denizd.feelings.fragment

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected abstract val binding: ViewBinding
    protected abstract val viewModel: ViewModel
    val name: String = javaClass.simpleName

    private lateinit var _context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _context = context
    }

    override fun getContext(): Context = _context
}