package com.example.graphqlchallenge.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolderList <T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}