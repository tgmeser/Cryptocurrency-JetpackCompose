package com.babyapps.cryptobaby.domain.use_case.get_coin

import com.babyapps.cryptobaby.data.remote.dto.mapToCoinDetail
import com.babyapps.cryptobaby.domain.model.CoinDetail
import com.babyapps.cryptobaby.domain.repository.CoinRepository
import com.babyapps.cryptobaby.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())

            val coin = coinRepository.getCoinById(coinId).mapToCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "HTTP error occured!"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?: "Network Connection error occured!"))
        }
    }
}