package com.denizd.feelings.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.denizd.feelings.R
import com.denizd.feelings.databinding.FragmentFeelingsBinding
import com.denizd.feelings.util.getTextColor
import com.denizd.feelings.util.viewBinding
import com.denizd.feelings.viewmodel.FeelingsViewModel

class FeelingsFragment : BaseFragment(R.layout.fragment_feelings) {

    override val binding: FragmentFeelingsBinding by viewBinding(FragmentFeelingsBinding::bind)
    override val viewModel: FeelingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            listOf(buttonAwful, buttonBad, buttonNeutral, buttonGood, buttonFantastic)
                .forEachIndexed { index, textButton ->
                    textButton.setOnClickListener { updateUi(index) }
                }
        }
    }

    private fun updateUi(rating: Int) {
        binding.shareSubheader.text = when (rating) {
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
        context.getColor(when (rating) {
            0 -> R.color.colorBackgroundAwful
            1 -> R.color.colorBackgroundBad
            2 -> R.color.colorBackgroundNeutral
            3 -> R.color.colorBackgroundGood
            else -> R.color.colorBackgroundFantastic
        }).also { backgroundColor ->
            binding.rootContainer.setBackgroundColor(backgroundColor)
            context.getTextColor(backgroundColor).also { textColor ->
                binding.header.setTextColor(textColor)
                binding.shareSubheader.setTextColor(textColor)
            }
        }
    }

    private fun insert(rating: Int, reason: String) {
        viewModel.insert(rating, reason)
    }
}