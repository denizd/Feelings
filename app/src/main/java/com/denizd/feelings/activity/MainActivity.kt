package com.denizd.feelings.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denizd.feelings.R
import com.denizd.feelings.data.Dependencies
import com.denizd.feelings.databinding.ActivityMainBinding
import com.denizd.feelings.fragment.EntryFragment
import com.denizd.feelings.fragment.OverviewFragment
import com.denizd.feelings.util.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)
    // TODO if adding ViewModel, use `by activityViewModels<>()`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Dependencies.init(this)
    }

    override fun onResume() {
        super.onResume()
        if (supportFragmentManager.fragments.size == 0) initFragments()
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction().apply {
            listOf(EntryFragment(), OverviewFragment()).forEach { fragment ->
                add(R.id.fragment_container, fragment, fragment.name)
                if (fragment.name != EntryFragment::class.java.simpleName) hide(fragment)
            }
        }.commit()
    }

    fun launchOverview() {
        supportFragmentManager.apply {
            beginTransaction().also { t ->
                t.hide(fragments[0])
                t.show(findFragmentByTag(OverviewFragment::class.java.simpleName)
                    ?: throw IllegalStateException("OverviewFragment not found"))
            }.commit()
        }
    }
}