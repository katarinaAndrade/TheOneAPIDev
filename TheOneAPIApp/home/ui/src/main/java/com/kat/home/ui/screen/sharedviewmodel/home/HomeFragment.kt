package com.kat.home.ui.screen.sharedviewmodel.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.kat.home.domain.data.Constants
import com.kat.home.domain.data.model.modeltypes.Movie
import com.kat.home.domain.data.model.modeltypes.ResponseBook
import com.kat.home.domain.data.model.modeltypes.ResponseMovie
import com.kat.home.ui.R
import com.kat.home.ui.databinding.FragmentHomeBinding
import com.kat.home.ui.screen.sharedviewmodel.home.adapter.HomeAdapter
import com.kat.home.ui.screen.sharedviewmodel.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), HomeContract {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private val firebase: Firebase by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadInfos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun loadInfos() {
        viewModel.load(Constants.TYPE_SEARCH_BOOK, null)
//        viewModel.load(Constants.TYPE_SEARCH_MOVIE, null)
        viewModel.responseBook.observe(viewLifecycleOwner) { result -> setupView(result, Constants.TYPE_SEARCH_BOOK) }
        viewModel.responseMovie.observe(viewLifecycleOwner) { result -> setupView(result, Constants.TYPE_SEARCH_MOVIE) }
    }

    private fun setupView(result: Any?, type: String) {
        result?.let {
            if (type == Constants.TYPE_SEARCH_BOOK) {
                (it as ResponseBook).docs?.let { listBooks ->
                    binding.rvBooks.adapter = HomeAdapter(
                        listBooks,
                        firebase.storage,
                        Constants.TYPE_SEARCH_BOOK,
                        this
                    )
                }
            } else {
                (it as ResponseMovie).docs?.let { listMovies ->
                    val lordOfTheRingsSeries = fixLists("LordOfTheRingsSeries", listMovies)
                    val hobbitSeries = fixLists("TheHobbitSeries", listMovies)
                }
            }
        }
    }

    private fun fixLists(series: String, list: List<Movie>): List<Movie> {
        val seriesMovies = mutableMapOf<String, Any>()
        firebase.firestore.collection(series)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    seriesMovies[document.id] = document.data
                }
            }
        if (seriesMovies.isEmpty()) return emptyList()

        val movies = mutableListOf<Movie>()
        seriesMovies.values.forEach { name ->
            list.forEach { movie ->
                if (movie.name!! == name)
                    movies.add(movie)
            }
        }

        return movies
    }

//    region - Contract
    override fun onSelectedItem(itemId: String, listCategory: String) {
        val bundle = bundleOf(
            "itemId" to itemId,
            "listCategory" to listCategory
        )
        findNavController().navigate(R.id.action_HomeFragment_to_DetailsFragment, bundle)
    }
//    endregion

}