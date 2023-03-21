package com.elpablo.shop.ui.screens.page1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elpablo.shop.core.utils.Response
import com.elpablo.shop.data.categories
import com.elpablo.shop.data.remote.dto.FlashSale
import com.elpablo.shop.data.remote.dto.Latest
import com.elpablo.shop.domain.use_case.GetLatestContentUseCase
import com.elpablo.shop.domain.use_case.GetSaleContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Page1ViewModel @Inject constructor(
    private val getLatest: GetLatestContentUseCase,
    private val getHotSale: GetSaleContentUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(Page1ViewState())
    val viewState: StateFlow<Page1ViewState> = _viewState

    init {
        getProductCategory()
        getContent()
    }

    fun onEvent(event: Page1Event) {
        when (event) {
            is Page1Event.SearchInput -> _viewState.value =
                _viewState.value.copy(searchInput = event.input)
        }
    }

    private fun getProductCategory() {
        _viewState.value = _viewState.value.copy(category = categories)
    }

    private fun getContent() {
        var latest: List<Latest>? = null
        var sale: List<FlashSale>? = null
        viewModelScope.launch {
            async {
                getLatest.invoke().collect { result ->
                    when (result) {
                        is Response.Success -> {
                            latest = result.data
                            _viewState.value = _viewState.value.copy(isLoading = false)
                        }

                        is Response.Error -> {
                            _viewState.value = _viewState.value.copy(isError = result.message)
                        }

                        is Response.Loading -> {
                            _viewState.value = _viewState.value.copy(isLoading = true)
                        }
                    }
                }
            }.await()

            async {
                getHotSale.invoke().collect { result ->
                    when (result) {
                        is Response.Success -> {
                            sale = result.data
                            _viewState.value = _viewState.value.copy(isLoading = false)
                        }

                        is Response.Error -> {
                            _viewState.value = _viewState.value.copy(isError = result.message)
                        }

                        is Response.Loading -> {
                            _viewState.value = _viewState.value.copy(isLoading = true)
                        }
                    }
                }
            }.await()

            _viewState.value = _viewState.value.copy(latest = latest)
            _viewState.value = _viewState.value.copy(sale = sale)
        }
    }
}