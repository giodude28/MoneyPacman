package io.giodude.moneypacman.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.giodude.moneypacman.View.AdDisView
import io.giodude.moneypacman.View.HomeView
import io.giodude.moneypacman.View.WayView

internal class MyPagerAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){

            0 -> {
                HomeView()
            }
            1 -> {
                WayView()
            }
            2 -> {
                AdDisView()
            }
//            3 -> {
//                BonusView()
//            }
//            4 -> {
//                PromoFragment()
//            }
            else -> getItem(position)

        }
    }

}