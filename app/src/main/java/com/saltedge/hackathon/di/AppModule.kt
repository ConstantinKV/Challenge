package com.saltedge.hackathon.di

import com.saltedge.hackathon.common.Constants
import com.saltedge.hackathon.data.remote.ApiInterface
import com.saltedge.hackathon.data.repository.AccountRepositoryImpl
import com.saltedge.hackathon.domain.repository.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideAccountRepository(api: ApiInterface): AccountRepository {
        return AccountRepositoryImpl(api = api)
    }
}