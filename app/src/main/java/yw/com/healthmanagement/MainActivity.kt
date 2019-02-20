package yw.com.healthmanagement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.fag1 -> {
                vp_content.currentItem = 0
            }
            R.id.fag2 -> {
                vp_content.currentItem = 1
            }
            R.id.fag3 -> {
                vp_content.currentItem = 2
            }
            R.id.fag4 -> {
                vp_content.currentItem = 3
            }
        }
    }

    private val fragmentList = ArrayList<Fragment>()
    lateinit var fragmentAdapter: HomeFragmentPageAdapter
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vp_content.addOnPageChangeListener(this)
        fag1.setOnClickListener(this)
        fag2.setOnClickListener(this)
        fag3.setOnClickListener(this)
        fag4.setOnClickListener(this)
        val fragment1 by lazy { Fragment1() }
        val fragment2 by lazy { Fragment2() }
        val fragment3 by lazy { Fragment3() }
        fragmentList.add(fragment1)
        fragmentList.add(fragment2)
        fragmentList.add(fragment3)
        fragmentAdapter = HomeFragmentPageAdapter(this.supportFragmentManager, fragmentList)
        vp_content.currentItem = 0
        vp_content.adapter = fragmentAdapter
    }

}
