package com.daveleron.jobber.swipeview

import androidx.recyclerview.widget.DiffUtil
import com.daveleron.jobber.data.Startup

class StackDiffCallback(
    private val old: List<Startup>,
    private val new: List<Startup>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].name == new[newPosition].name
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}