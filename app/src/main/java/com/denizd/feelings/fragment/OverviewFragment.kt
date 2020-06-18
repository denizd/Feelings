package com.denizd.feelings.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denizd.feelings.R
import com.denizd.feelings.adapter.EntryAdapter
import com.denizd.feelings.databinding.FragmentOverviewBinding
import com.denizd.feelings.util.viewBinding
import com.denizd.feelings.viewmodel.OverviewViewModel

class OverviewFragment : BaseFragment(R.layout.fragment_overview) {

    override val binding: FragmentOverviewBinding by viewBinding(FragmentOverviewBinding::bind)
    override val viewModel: OverviewViewModel by viewModels()

    private val entryAdapter: EntryAdapter = EntryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO doesn't show latest entry after coming from EntryFragment
        viewModel.allEntries.observe(viewLifecycleOwner, Observer { entries ->
            entryAdapter.set(entries)
        })

        binding.recyclerView.apply {
            adapter = entryAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}