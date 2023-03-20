package com.elpablo.shop.ui.screens.page1

import androidx.lifecycle.ViewModel
import com.elpablo.shop.data.categories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class Page1ViewModel @Inject constructor() : ViewModel() {

    private val _viewState = MutableStateFlow(Page1ViewState())
    val viewState: StateFlow<Page1ViewState> = _viewState

    init {
        getProductCategory()
    }

    fun onEvent(event: Page1Event) {
        when(event) {
            is Page1Event.SearchInput -> _viewState.value = _viewState.value.copy(searchInput = event.input)
        }
    }

    private fun getProductCategory() {
        _viewState.value = _viewState.value.copy(category = categories)
    }
}