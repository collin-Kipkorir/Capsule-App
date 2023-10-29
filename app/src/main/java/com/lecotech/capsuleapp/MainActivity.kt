package com.lecotech.capsuleapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: CapsulePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.theme)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        adapter = CapsulePagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Video"
                1 -> "Notes"
                2 -> "Quiz"
                3 -> "Result"
                else -> ""
            }
        }.attach()

        val timeLimitInMillis: Long = 10 * 60 * 1000 // 10 minutes in milliseconds

        val timer = object : CountDownTimer(timeLimitInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // You can implement logic for the ticking timer if necessary
            }

            override fun onFinish() {
                finish()
            }
        }
        timer.start()
    }
}
