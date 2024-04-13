package com.example.swing_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swing_assignment.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNav()

        // 초기 프래그먼트 설정
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FeedFragment())
                .commit()
        }
    }

    //BottomNavigation 세팅
    private fun setBottomNav() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_feed -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, FeedFragment()).commit()
                    true
                }
                R.id.fragment_bookmark -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, BookmarkFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}