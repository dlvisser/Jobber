package com.daveleron.jobber
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {

    // Splash screen timer
    private val SPLASH_TIME_OUT = 7000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        val tvJobberTitle : TextView = findViewById(R.id.tvJobberTitle)
        val tvJobberExplanation: TextView = findViewById(R.id.tvJobberExplanation)
        val tvJobberCreator: TextView = findViewById(R.id.tvMadeByCreator)

        tvJobberTitle.text = changeTextColor(R.string.app_name_title,0,3)
        tvJobberExplanation.text = changeTextColor(R.string.app_splashscreen_intro,resources.getString(R.string.app_splashscreen_intro).indexOf("start-ups"), resources.getString(R.string.app_splashscreen_intro).indexOf("ups")+3, resources.getString(R.string.app_splashscreen_intro).indexOf("programmers"),resources.getString(R.string.app_splashscreen_intro).length)
        tvJobberCreator.text = changeTextColor(R.string.app_creator_splashScreen, resources.getString(R.string.app_creator_splashScreen).indexOf("Dave"),resources.getString(R.string.app_creator_splashScreen).length)

        Handler().postDelayed(
                {
                    val i = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                    startActivity(i)
                    finish()
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
        val colorAccent = R.color.Primary_White
        mSpannableString.setSpan(colorPrimary, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        mSpannableString.setSpan(colorPrimary, startIndexTwo, endIndexTwo, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return mSpannableString
    }
}
