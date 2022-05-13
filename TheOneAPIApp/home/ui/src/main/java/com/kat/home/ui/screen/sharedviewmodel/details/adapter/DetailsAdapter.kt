package com.kat.home.ui.screen.sharedviewmodel.details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kat.home.ui.screen.sharedviewmodel.details.DetailsContract

class DetailsAdapter(
    private val list: List<Any>,
    private val detailsContract: DetailsContract
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size
}