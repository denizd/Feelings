package com.denizd.feelings.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denizd.feelings.R
import com.denizd.feelings.data.Dependencies
import com.denizd.feelings.databinding.ActivityMainBinding
import com.denizd.feelings.fragment.FeelingsFragment
import com.denizd.feelings.util.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

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
            listOf(FeelingsFragment()).forEach { fragment ->
                add(R.id.fragment_container, fragment, fragment.name)
                if (fragment.name != FeelingsFragment::class.java.simpleName) hide(fragment)
            }
        }.commit()
    }
}