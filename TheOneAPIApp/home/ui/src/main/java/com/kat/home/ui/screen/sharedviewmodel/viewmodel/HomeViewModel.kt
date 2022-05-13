package com.kat.home.ui.screen.sharedviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kat.home.domain.data.model.Params
import com.kat.home.domain.data.model.modeltypes.*

abstract class HomeViewModel: ViewModel() {

    abstract val responseBook: LiveData<ResponseBook?>
    abstract val responseCharacter: LiveData<ResponseCharacter?>
    abstract val responseMovie: LiveData<ResponseMovie?>
    abstract val responseQuote: LiveData<ResponseQuote?>

    abstract fun load(searchType: String, params: Params?)

}