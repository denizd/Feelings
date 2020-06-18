package com.denizd.feelings.fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.denizd.feelings.R
import com.denizd.feelings.activity.MainActivity
import com.denizd.feelings.databinding.FragmentEntryBinding
import com.denizd.feelings.util.getTextColor
import com.denizd.feelings.util.viewBinding
import com.denizd.feelings.viewmodel.EntryViewModel

class EntryFragment : BaseFragment(R.layout.fragment_entry) {

    override val binding: FragmentEntryBinding by viewBinding(FragmentEntryBinding::bind)
    override val viewModel: EntryViewModel by viewModels()

    private var currentRating: Int = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            listOf(buttonAwful, buttonBad, buttonNeutral, buttonGood, buttonFantastic)
                .forEachIndexed { index, textButton ->
                    textButton.setOnClickListener { updateUi(index) }
                }
            shareField.doAfterTextChanged {
                textLimitIndicator.text = (64 - it.toString().length).toString()
            }
            saveButton.setOnClickListener {
                insert(currentRating, shareField.text.toString())
                (activity as? MainActivity)?.launchOverview()
            }
        }
    }

    private fun updateUi(rating: Int) {
        currentRating = rating
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
        binding.apply {
            shareSubheader.visibility = View.VISIBLE
            shareFieldLayout.visibility = View.VISIBLE
            textLimitIndicator.visibility = View.VISIBLE
            saveButton.visibility = View.VISIBLE
        }
    }

    private fun insert(rating: Int, reason: String) {
        viewModel.insert(rating, reason)
    }
}