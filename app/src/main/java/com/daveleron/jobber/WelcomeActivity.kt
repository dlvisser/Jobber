package com.daveleron.jobber
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val tvWelcomeText : TextView = findViewById(R.id.welcomeTextView)
        tvWelcomeText.text = changeTextColor(R.string.welcome_screen_text,resources.getString(R.string.welcome_screen_text).indexOf("you"),resources.getString(R.string.welcome_screen_text).indexOf("you") + 3)
        tvWelcomeText.setOnClickListener {
            val i = Intent(this@WelcomeActivity, SelectionScreenActivity::class.java)
            startActivity(i)
            finish()
        }


    }

    private fun changeTextColor(textResource : Int,startIndex : Int, endIndex : Int): SpannableString {
        val mSpannableString = SpannableString(resources.getString(textResource))
        val colorPrimary = ForegroundColorSpan(resources.getColor(R.color.Primary_Green))
        mSpannableString.setSpan(colorPrimary, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return mSpannableString
    }
}