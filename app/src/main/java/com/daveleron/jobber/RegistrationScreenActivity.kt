package com.daveleron.jobber
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daveleron.jobber.data.DataStorage
import com.daveleron.jobber.data.Programmer
import com.daveleron.jobber.data.Startup
import com.daveleron.jobber.fragments.registration.ProgrammerRegistrationFragment
import com.daveleron.jobber.fragments.registration.StartupRegistrationFragment

class RegistrationScreenActivity : AppCompatActivity() {

    private lateinit var currentFragment : Fragment
    private lateinit var fragmentType : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val tvLetsGetStarted : TextView = findViewById(R.id.letsGetStartedTextView)
        tvLetsGetStarted.text = changeTextColor(R.string.registration_screen_lets_get_started,resources.getString(R.string.registration_screen_lets_get_started).indexOf("started"),resources.getString(R.string.registration_screen_lets_get_started).length)
        fragmentType = intent.getStringExtra("fragment_type")
        setFragment(fragmentType)
    }

    private fun changeTextColor(textResource : Int,startIndex : Int, endIndex : Int): SpannableString {
        val mSpannableString = SpannableString(resources.getString(textResource))
        val colorPrimary = ForegroundColorSpan(resources.getColor(R.color.Primary_Green))
        mSpannableString.setSpan(colorPrimary, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return mSpannableString
    }

    private fun setFragment(type : String){
        var fragManager : FragmentManager = supportFragmentManager
        var fragmentTransaction : FragmentTransaction = fragManager.beginTransaction()

        when (type) {
            "Programmer" -> currentFragment = ProgrammerRegistrationFragment()
            "Startup" -> currentFragment = StartupRegistrationFragment()
            else -> { // Note the block
                Toast.makeText(this@RegistrationScreenActivity,"WRONG TYPE FRAGMENT",Toast.LENGTH_LONG)
            }
        }

        fragmentTransaction.add(R.id.fragment,currentFragment)
        fragmentTransaction.commit()
    }

    fun btnContinuePressed(v : View){
        val i = Intent(this@RegistrationScreenActivity, SwipeScreenActivity::class.java)
        i.putExtra("list_type",fragmentType)
        startActivity(i)
        finish()
        //Toast.makeText(this,"HELLO",Toast.LENGTH_LONG)
    }
}