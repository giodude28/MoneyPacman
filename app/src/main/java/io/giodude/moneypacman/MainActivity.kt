package io.giodude.moneypacman

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.synnapps.carouselview.CarouselView
import io.giodude.moneypacman.Adapter.MyPagerAdapter

class MainActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false
    lateinit var  tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var carouselImages = intArrayOf(R.drawable.app1, R.drawable.app2, R.drawable.app3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (checkNetwork()) {

//            nointernet.isVisible = false
//            carouselView.isVisible = true
//            tablayout.isVisible = true
//            pager.isVisible = true

            var carouselView = findViewById<CarouselView>(R.id.carouselView)
            carouselView.pageCount = carouselImages.size

            carouselView.setImageListener { position, imageView ->
                imageView.setImageResource(carouselImages[position])
            }

        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.pager)
        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Ways to Earn"))
        tabLayout.addTab(tabLayout.newTab().setText("Advantage and Disadvantage"))
//        tabLayout.addTab(tabLayout.newTab().setText("Nhều hơn"))
//            tabLayout.addTab(tabLayout.newTab().setText("Khuyến mại"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyPagerAdapter(this, supportFragmentManager, tabLayout.tabCount)

        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
//        }

//        else {
//            nointernet.isVisible = true
//            carouselView.isVisible = false
//            tablayout.isVisible = false
//            pager.isVisible = false
//        }

    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Nhấn QUAY LẠI một lần nữa để thoát", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun checkNetwork(): Boolean {
        val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return true
    }
}