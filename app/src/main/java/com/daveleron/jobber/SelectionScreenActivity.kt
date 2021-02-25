package com.daveleron.jobber
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SelectionScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
    }

    fun onClickProgrammer(v : View){
        val i = Intent(this@SelectionScreenActivity, RegistrationScreenActivity::class.java)
        i.putExtra("fragment_type","Programmer")
        startActivity(i)
        finish()
    }

    fun onClickStartup(v : View){
        val i = Intent(this@SelectionScreenActivity, RegistrationScreenActivity::class.java)
        i.putExtra("fragment_type","Startup")
        startActivity(i)
        finish()
    }

}