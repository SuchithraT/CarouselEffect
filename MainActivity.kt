package com.example.carouselpoc

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    var myViewPagerAdapter: MyViewPagerAdapter? = null
    private var indicator_layout: LinearLayout? = null
    private var dotsLayout: LinearLayout? = null
    private lateinit var dots: Array<TextView?>
    lateinit var layouts: IntArray
    var btnSkip: Button? = null
    var btnNext: Button? = null
    var btnDone: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Making notification bar transparent

        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        indicator_layout = findViewById(R.id.layoutIndicator)
        dotsLayout = findViewById(R.id.layoutDots)
        btnSkip = findViewById(R.id.btn_skip)
        btnNext = findViewById(R.id.btn_next)
        btnDone = findViewById(R.id.btn_done)


        // layouts of all sliders
        // add few more layouts if you want

        layouts = intArrayOf(
            R.layout.welcome_slide1,
            R.layout.welcome_slide2,
            R.layout.welcome_slide3,
            R.layout.welcome_slide4,
            R.layout.welcome_slide5
        )

        // adding bottom dots
        addBottomDots(0)

        // making notification bar transparent
        changeStatusBarColor()

        myViewPagerAdapter = MyViewPagerAdapter()
        viewPager!!.adapter = myViewPagerAdapter
        viewPager!!.addOnPageChangeListener(viewPagerPageChangeListener)


        btnSkip!!.setOnClickListener {
            //launchHomeScreen()
            }

            btnNext!!.setOnClickListener {
                // checking for last page
                // if last page home screen will be launched
                val current: Int = getItem(+1)
                if (current < layouts.size) {
                    // move to next screen
                    viewPager!!.currentItem = current
                } else {
                    // launchHomeScreen()
                }
            }

        btnDone!!.setOnClickListener {
            //launchHomeScreen()
        }


    }

    fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)

        dotsLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.gravity=Gravity.CENTER
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(resources.getColor(R.color.dot_light_blue))
            dotsLayout!!.addView(dots[i])
        }
        if (dots.isNotEmpty()) dots[currentPage]!!.setTextColor(resources.getColor(R.color.dot_dark_blue))
    }

    private fun getItem(i: Int): Int {
            return viewPager!!.currentItem + i
        }

    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object :
        ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            if (position == layouts.size - 1) {
                btnDone!!.visibility = View.VISIBLE
                btnNext!!.visibility = View.GONE
                btnSkip!!.visibility = View.GONE
                var tv_title:TextView=findViewById(R.id.slide5_title)
                tv_title.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var tv_desc:TextView=findViewById(R.id.slide5_desc)
                tv_desc.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobGreen: ImageView =findViewById(R.id.blob5_green)
                iv_blobGreen.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobBlue: ImageView =findViewById(R.id.blob5_blue)
                iv_blobBlue.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobMobile: ImageView =findViewById(R.id.blob5_mobile)
                iv_blobMobile.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in))
                var iv_blobTouch: ImageView =findViewById(R.id.blob5_touch)
                iv_blobTouch.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in))
                var iv_blobCard: ImageView =findViewById(R.id.blob5_card)
                iv_blobCard.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in))
            }

            else if (position == layouts.size - 2) {
                btnNext!!.visibility = View.VISIBLE
                btnSkip!!.visibility = View.VISIBLE
                btnDone!!.visibility = View.GONE
                var tv_title:TextView=findViewById(R.id.slide4_title)
                tv_title.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var tv_desc:TextView=findViewById(R.id.slide4_desc)
                tv_desc.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobGreen: ImageView =findViewById(R.id.blob4_green)
                iv_blobGreen.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobBlue: ImageView =findViewById(R.id.blob4_blue)
                iv_blobBlue.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobMobile: ImageView =findViewById(R.id.blob4_mobile)
                iv_blobMobile.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in))
                var iv_blobCard: ImageView =findViewById(R.id.blob4_card)
                iv_blobCard.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in))
            }
            else if (position == layouts.size - 3) {
                btnNext!!.visibility = View.VISIBLE
                btnSkip!!.visibility = View.VISIBLE
                btnDone!!.visibility = View.GONE
                var tv_title:TextView=findViewById(R.id.slide3_title)
                tv_title.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var tv_desc:TextView=findViewById(R.id.slide3_desc)
                tv_desc.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobGreen: ImageView =findViewById(R.id.blob3_green)
                iv_blobGreen.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobBlue: ImageView =findViewById(R.id.blob3_blue)
                iv_blobBlue.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobMobile: ImageView =findViewById(R.id.blob3_mobile)
                iv_blobMobile.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in))
                var iv_blobCard: ImageView =findViewById(R.id.blob3_card)
                iv_blobCard.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in))

            }

            else if (position == layouts.size - 4) {
                btnNext!!.visibility = View.VISIBLE
                btnSkip!!.visibility = View.VISIBLE
                btnDone!!.visibility = View.GONE
                var tv_title:TextView=findViewById(R.id.slide2_title)
                tv_title.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var tv_desc:TextView=findViewById(R.id.slide2_desc)
                tv_desc.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobGreen: ImageView =findViewById(R.id.blob2_green)
                iv_blobGreen.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobBlue: ImageView =findViewById(R.id.blob2_blue)
                iv_blobBlue.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right))
                var iv_blobMobile: ImageView =findViewById(R.id.blob2_mobile)
                iv_blobMobile.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up))
                var iv_blobTouch: ImageView =findViewById(R.id.blob2_touch)
                iv_blobTouch.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in))
                var iv_blobFace: ImageView =findViewById(R.id.blob2_faceid)
                iv_blobFace.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in))

            }

            else {
                btnNext!!.visibility = View.VISIBLE
                btnSkip!!.visibility = View.VISIBLE
                btnDone!!.visibility = View.GONE
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {

        }

    }

    /*** Making notification bar transparent*/
    private fun changeStatusBarColor() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            }
        }



        /*** View pager adapter*/
        class MyViewPagerAdapter : PagerAdapter() {

            var layouts : IntArray= intArrayOf(
              R.layout.welcome_slide1,
             R.layout.welcome_slide2,
             R.layout.welcome_slide3,
             R.layout.welcome_slide4,
            R.layout.welcome_slide5
            )

            override fun instantiateItem(viewGroup: ViewGroup, position: Int): Any =
                LayoutInflater.from(viewGroup.context).inflate(layouts[position], viewGroup, false).also {
                    viewGroup.addView(it)
                }

            override fun getCount(): Int {
                return layouts.size

            }

            override fun isViewFromObject(view: View, `obj`: Any): Boolean {
                return view === obj

            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                val view = `object` as View?
                container.removeView(view)
            }
        }

    }


