package com.daveleron.jobber.recyclerview.chathorizontal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.daveleron.jobber.R
import com.daveleron.jobber.data.Startup

class HorizontalChatAdapter(private val dataSet: ArrayList<Startup>, private val context: Context) : RecyclerView.Adapter<HorizontalChatAdapter.ViewHolder>() {

    var onItemClick : ((Startup) -> Unit)? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageView : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            imageView = view.findViewById(R.id.ivChatHorizontal)
            view.setOnClickListener(View.OnClickListener { onItemClick?.invoke(dataSet.get(adapterPosition)) })
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.chat_item_horizontal, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.imageView.setImageDrawable(context.resources.getDrawable(dataSet.get(position).image))
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size



}