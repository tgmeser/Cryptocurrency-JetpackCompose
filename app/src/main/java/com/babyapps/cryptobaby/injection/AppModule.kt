package com.babyapps.cryptobaby.injection

import com.babyapps.cryptobaby.data.remote.CoinApi
import com.babyapps.cryptobaby.data.repository.CoinRepositoryImpl
import com.babyapps.cryptobaby.domain.repository.CoinRepository
import com.babyapps.cryptobaby.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCoinApi(): CoinApi = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(CoinApi::class.java)

    @Provides
    fun provideCoinRepository(coinApi: CoinApi): CoinRepository = CoinRepositoryImpl(coinApi)

}