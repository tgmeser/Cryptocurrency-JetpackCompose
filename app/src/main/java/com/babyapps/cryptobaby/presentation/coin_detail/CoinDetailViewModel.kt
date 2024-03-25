package com.babyapps.cryptobaby.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babyapps.cryptobaby.domain.use_case.get_coin.GetCoinUseCase
import com.babyapps.cryptobaby.util.Constants
import com.babyapps.cryptobaby.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    // SavedstateHandle contains navigation parameters , Coins->CoinDetail (coinID)
    private val savedStateHandle: SavedStateHandle
    ) :
    ViewModel() {
    private var _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIND_ID)?.let { getCoin(it) }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = it.data)
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = it.message?: "An error occured..!")
                }
            }
        }.launchIn(viewModelScope)
    }
}