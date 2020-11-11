package com.daveleron.jobber
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.transition.Explode
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {

    // Splash screen timer
    private val SPLASH_TIME_OUT = 4000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        val tvJobberTitle : TextView = findViewById(R.id.jobberTitleTextView)
        val tvJobberExplanation: TextView = findViewById(R.id.jobberExplanationTextView)
        val tvJobberCreator: TextView = findViewById(R.id.madeByCreatorTextView)

        tvJobberTitle.text = changeTextColor(R.string.app_name_title,0,3)
        tvJobberExplanation.text = changeTextColor(R.string.app_splashscreen_intro,resources.getString(R.string.app_splashscreen_intro).indexOf("start-ups"), resources.getString(R.string.app_splashscreen_intro).indexOf("start-ups")+9, resources.getString(R.string.app_splashscreen_intro).indexOf("programmers"),resources.getString(R.string.app_splashscreen_intro).length)
        tvJobberCreator.text = changeTextColor(R.string.app_creator_splashScreen, resources.getString(R.string.app_creator_splashScreen).indexOf("Dave"),resources.getString(R.string.app_creator_splashScreen).length)


        Handler().postDelayed(
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        val i = Intent(this@SplashScreenActivity, WelcomeActivity::class.java)
                        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                        finish()
                    }
                    else {
                        val i = Intent(this@SplashScreenActivity, WelcomeActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                }, SPLASH_TIME_OUT)
    }

    private fun changeTextColor(textResource : Int,startIndex : Int, endIndex : Int): SpannableString {
        val mSpannableString = SpannableString(resources.getString(textResource))
        val colorPrimary = ForegroundColorSpan(resources.getColor(R.color.Primary_Green))
        val colorAccent = R.color.Primary_White
        mSpannableString.setSpan(colorPrimary, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return mSpannableString
    }

    private fun changeTextColor(textResource : Int,startIndex : Int, endIndex : Int, startIndexTwo : Int, endIndexTwo : Int): SpannableString {
        val mSpannableString = SpannableString(resources.getString(textResource))
        val colorPrimary = ForegroundColorSpan(resources.getColor(R.color.Primary_Green))
        val colorSecond = ForegroundColorSpan(resources.getColor(R.color.Primary_Green))
        mSpannableString.setSpan(colorPrimary, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        mSpannableString.setSpan(colorSecond, startIndexTwo, endIndexTwo, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        return mSpannableString
    }
}
