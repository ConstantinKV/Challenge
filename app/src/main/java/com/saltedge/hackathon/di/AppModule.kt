package com.saltedge.hackathon.di

import com.saltedge.hackathon.common.Constants
import com.saltedge.hackathon.data.remote.ApiInterface
import com.saltedge.hackathon.data.remote.network.createHttpLoginInterceptor
import com.saltedge.hackathon.data.remote.network.getUnsafeOkHttpClient
import com.saltedge.hackathon.data.repository.AccountRepositoryImpl
import com.saltedge.hackathon.data.repository.ConsentRepositoryImpl
import com.saltedge.hackathon.data.repository.AccessTokenRepositoryImpl
import com.saltedge.hackathon.domain.repository.AccessTokenRepository
import com.saltedge.hackathon.domain.repository.AccountRepository
import com.saltedge.hackathon.domain.repository.ConsentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createHttpLoginInterceptor())
            .getUnsafeOkHttpClient()
            .build()
    }

    @Provides
    @Singleton
    fun provideAccountRepository(api: ApiInterface): AccountRepository {
        return AccountRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(api: ApiInterface): AccessTokenRepository {
        return AccessTokenRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideConsentRepository(api: ApiInterface): ConsentRepository {
        return ConsentRepositoryImpl(api = api)
    }
}