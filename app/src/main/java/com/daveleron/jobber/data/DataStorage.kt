package com.daveleron.jobber.data

import androidx.annotation.Nullable
import com.daveleron.jobber.R
import java.util.*
import kotlin.collections.ArrayList

class DataStorage private constructor(){

    private object HOLDER {
        val INSTANCE = DataStorage()
    }

    companion object {
        val instance: DataStorage by lazy { HOLDER.INSTANCE }
    }

    var programmerStorageList : ArrayList<Programmer>
    var startupStorageList : ArrayList<Startup>
    var selectedList: ArrayList<Startup>

    init {
        programmerStorageList = createProgrammerList()
        startupStorageList = createStartupList()
        selectedList = ArrayList()
    }

    fun createProgrammerList() : ArrayList<Programmer>{
        var ar = ArrayList<Programmer>()

        ar.add(Programmer("Dave Visser","dlvisser@test.nl","davetest.com",
            "Man","Dutch", R.drawable.programmer))
        ar.add(Programmer("Test Test","test@test.nl","test.com",
            "Man","Dutch", R.drawable.programmer))
        ar.add(Programmer("Persoons naam","persoon@test.nl","persoon.com",
            "Man","Dutch", R.drawable.programmer))

        return ar
    }

    fun createStartupList() : ArrayList<Startup>{
        var ar = ArrayList<Startup>()

        ar.add(
            Startup("Gogle","gogl@test.com","gogl.com",
            "1234 AB", "United-States", "English", R.drawable.gogle))
        ar.add(
            Startup("Amazing","Amazing@test.com","amazing.com",
            "1234 AB","United-States","English", R.drawable.amazing))
        ar.add(Startup("LeenBike","LeenBike@test.nl","leenBike.com",
            "1234 AB","The Netherlands","Dutch", R.drawable.leenbike))
        ar.add(
            Startup("Playbox","playbox@test.com","Playbox.com",
                "1234 AB","Japan","English", R.drawable.playbox))
        ar.add(
            Startup("Pear","Pear@test.com","Pear.com",
                "1234 AB","United-States","English", R.drawable.pear))
        ar.add(
            Startup("PH","PH@test.com","PH.com",
                "1234 AB","Great Britain","English", R.drawable.ph))
        ar.add(
            Startup("RANDOM","random@test.com","random.com",
                "1234 AB","RANDOM","English", R.drawable.startup_icon))
        ar.add(Startup("SmagSmug","SmagSmug@test.nl","SmagSmug.com",
            "1234 AB","The Netherlands","Dutch", R.drawable.smagsmug))

        return ar
    }
}