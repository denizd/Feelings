package com.denizd.feelings.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.denizd.feelings.R
import com.denizd.feelings.databinding.FragmentFeelingsBinding
import com.denizd.feelings.util.viewBinding
import com.denizd.feelings.viewmodel.FeelingsViewModel

class FeelingsFragment : BaseFragment(R.layout.fragment_feelings) {

    override val binding: FragmentFeelingsBinding by viewBinding(FragmentFeelingsBinding::bind)
    override val viewModel: FeelingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun TextView.setEmotionText(rating: Int) {
        text = when (rating) {
            0 -> getString(R.string.feelings_subheader_awful)
            1 -> getString(R.string.feelings_subheader_bad)
            2 -> getString(R.string.feelings_subheader_neutral)
            else -> getString(R.string.feelings_subheader_placeholder_positive,
                resources.getStringArray(
                    if (rating == 3)
                        R.array.feelings_placefiller_good
                    else
                        R.array.feelings_placefiller_fantastic
                ).random()
            )
        }
    }

    private fun insert(rating: Int, reason: String) {
        viewModel.insert(rating, reason)
    }
}