package com.babyapps.cryptobaby.domain.use_case.get_coins

import com.babyapps.cryptobaby.data.remote.dto.mapToCoin
import com.babyapps.cryptobaby.domain.model.Coin
import com.babyapps.cryptobaby.domain.repository.CoinRepository
import com.babyapps.cryptobaby.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    // It could be like this via creating a function
    // fun execute(): Flow<Resource<List<Coin>>>

    // But we wanted quick use case access
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            // Firstly create Loading status..!
            emit(Resource.Loading())

            // Now we ll have coins and we need to create Success status..!
            val coinList = repository.getCoins().map { it.mapToCoin() }
            emit(Resource.Success(coinList))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "HTTP error occured!"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?: "Network Connection error occured!"))
        }
    }

}