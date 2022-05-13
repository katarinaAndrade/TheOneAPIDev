package com.kat.home.ui.screen.sharedviewmodel.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.kat.home.domain.data.Constants
import com.kat.home.domain.data.model.modeltypes.Book
import com.kat.home.domain.data.model.modeltypes.Movie
import com.kat.home.ui.R
import com.kat.home.ui.databinding.ItemHomeBinding
import com.kat.home.ui.screen.sharedviewmodel.home.HomeContract
import com.squareup.picasso.Picasso

class HomeViewHolder(
    private val view: View,
    private val homeContract: HomeContract,
    private val storage: FirebaseStorage
) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHomeBinding.bind(view)

    fun bindTo(item: Any, itemCategory: String) {
        when (itemCategory) {
            Constants.TYPE_SEARCH_BOOK -> {
                item as Book
                binding.itemTitle.text = item.name
                bookPoster(item.name)
                binding.containerItem.setOnClickListener {
                    item.id?.let { onSelected(it, itemCategory) }
                }
            }
            Constants.TYPE_SEARCH_MOVIE -> {
                item as Movie
                binding.itemTitle.text = item.name
                moviePoster(item.name)
                binding.containerItem.setOnClickListener {
                    item.id?.let { onSelected(it, itemCategory) }
                }
            }
        }
    }

    private fun bookPoster(name: String?) {
        when (name) {
            "The Fellowship Of The Ring" -> load("gs://theoneapi-3950d.appspot.com/the_fellowship_of_the_ring_book.jpeg")
            "The Two Towers" -> load("gs://theoneapi-3950d.appspot.com/the_two_towers_book.jpeg")
            "The Return Of The King" -> load("gs://theoneapi-3950d.appspot.com/the_return_of_the_king_book.jpeg")
        }
    }

    private fun moviePoster(name: String?) {
        when (name) {
            "The Lord of the Rings Series" -> load("gs://theoneapi-3950d.appspot.com/lord_of_the_rings_series.jpeg")
            "The Hobbit Series" -> load("gs://theoneapi-3950d.appspot.com/the_hobbit_series.jpeg")
            "The Unexpected Journey" -> load("gs://theoneapi-3950d.appspot.com/the_hobbit_an_unexpected_journey.jpeg")
            "The Desolation of Smaug" -> load("gs://theoneapi-3950d.appspot.com/the_desolation_of_smaug.jpeg")
            "The Battle of the Five Armies" -> load("gs://theoneapi-3950d.appspot.com/the_hobbit_the_battle_of_the_five_armies.jpeg")
            "The Two Towers" -> load("gs://theoneapi-3950d.appspot.com/lord_of_the_rings_two_towers.jpeg")
            "The Fellowship of the Ring" -> load("gs://theoneapi-3950d.appspot.com/lord_of_the_rings_series.jpeg")
            "The Return of the King" -> load("gs://theoneapi-3950d.appspot.com/the_return_of_the_king.jpg")
        }
    }

    private fun load(location: String) {
        storage.reference.child(location).downloadUrl.addOnSuccessListener {
            Picasso.get()
                .load(it)
                .into(binding.posterImg)
        }
    }

    private fun onSelected(itemId: String, itemCategory: String) {
        homeContract.onSelectedItem(itemId, itemCategory)
    }

    companion object {
        fun create(
            parent: ViewGroup,
            homeContract: HomeContract,
            storage: FirebaseStorage
        ): HomeViewHolder {
            LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false).let {
                return HomeViewHolder(it, homeContract, storage)
            }
        }
    }

}