package com.daveleron.jobber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daveleron.jobber.data.DataStorage
import com.daveleron.jobber.recyclerview.chathorizontal.HorizontalChatAdapter
import com.daveleron.jobber.recyclerview.chathorizontal.VerticalChatAdapter

class ChatScreenActivity : AppCompatActivity() {

    private lateinit var horizontalChatRecyclerView : RecyclerView
    private lateinit var verticalChatRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatscreen)
        initRecyclerViews()
    }

    fun initRecyclerViews(){
        val horizontalChatAdapter = HorizontalChatAdapter(DataStorage.instance.selectedList,this)
        val verticalChatAdapter = VerticalChatAdapter(DataStorage.instance.selectedList,this)

        horizontalChatRecyclerView = findViewById(R.id.rvChatsHorizontal)
        verticalChatRecyclerView = findViewById(R.id.rvChatsVertical)

        horizontalChatRecyclerView.adapter = horizontalChatAdapter
        verticalChatRecyclerView.adapter = verticalChatAdapter

        horizontalChatAdapter.onItemClick = { startup ->  Toast.makeText(this,startup.name,Toast.LENGTH_LONG).show()}
        verticalChatAdapter.onItemClick = { startup ->  Toast.makeText(this,startup.name,Toast.LENGTH_LONG).show()}


        horizontalChatRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        verticalChatRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()

        horizontalChatRecyclerView.invalidate()
        verticalChatRecyclerView.invalidate()

    }
}