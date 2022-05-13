package com.kat.home.ui.screen.sharedviewmodel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kat.home.domain.data.Constants
import com.kat.home.domain.data.model.Params
import com.kat.home.domain.data.model.modeltypes.*
import com.kat.home.domain.data.usecase.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val useCase: HomeUseCase
): HomeViewModel() {

    override val responseBook = MutableLiveData<ResponseBook?>()
    override val responseCharacter = MutableLiveData<ResponseCharacter?>()
    override val responseMovie = MutableLiveData<ResponseMovie?>()
    override val responseQuote = MutableLiveData<ResponseQuote?>()

    override fun load(searchType: String, params: Params?) {
        viewModelScope.launch {
            try {
                when(searchType) {
                    Constants.TYPE_SEARCH_BOOK -> {
                        val result = useCase.loadData<ResponseBook>(typeData = searchType, params = params)
                        responseBook.value = result
                    }
                    Constants.TYPE_SEARCH_CHARACTER -> {
                        val result = useCase.loadData<ResponseCharacter>(typeData = searchType, params = params)
                        responseCharacter.value = result
                    }
                    Constants.TYPE_SEARCH_MOVIE -> {
                        val result = useCase.loadData<ResponseMovie>(typeData = searchType, params = params)
                        responseMovie.value = result
                    }
                    Constants.TYPE_SEARCH_QUOTE -> {
                        val result = useCase.loadData<ResponseQuote>(typeData = searchType, params = params)
                        responseQuote.value = result
                    }
                }
            } catch (e: Exception) {
                Log.d(HomeViewModelImpl::class.simpleName, e.message.toString())
            }
        }
    }

}