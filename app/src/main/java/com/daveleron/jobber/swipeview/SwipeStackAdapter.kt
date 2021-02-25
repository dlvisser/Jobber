package com.daveleron.jobber.swipeview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.daveleron.jobber.R
import com.daveleron.jobber.data.Startup

class CardStackAdapter(
    private var startups: List<Startup> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {
    private lateinit var context : ViewGroup;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent
        return ViewHolder(inflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val startup = startups[position]
        holder.name.text = startup.name
        holder.country.text = startup.country
        holder.image.setImageDrawable(context.resources.getDrawable(startup.image))
//        holder.itemView.setOnClickListener { v ->
//            Intent intent = Intent(context, SwipeScreenDetail)
//            Toast.makeText(v.context, startup.name, Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int {
        return startups.size
    }

    fun setStartup(startups: List<Startup>) {
        this.startups = startups
    }

    fun getStartup(): List<Startup> {
        return startups
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name)
        var country: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)
    }

}