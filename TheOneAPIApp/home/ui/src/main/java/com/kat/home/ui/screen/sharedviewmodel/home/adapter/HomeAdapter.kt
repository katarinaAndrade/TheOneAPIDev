package com.kat.home.ui.screen.sharedviewmodel.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.kat.home.ui.screen.sharedviewmodel.home.HomeContract

class HomeAdapter(
    private val list: List<Any>,
    private val storage: FirebaseStorage,
    private val listCategory: String,
    private val homeContract: HomeContract
) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder.create(parent, homeContract, storage)

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindTo(list[position], listCategory)
    }

    override fun getItemCount(): Int = list.size
}