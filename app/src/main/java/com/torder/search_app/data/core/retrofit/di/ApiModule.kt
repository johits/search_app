package com.torder.search_app.data.core.retrofit.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.torder.search_app.data.core.retrofit.constant.RetrofitConstant.KAKAO_URL
import com.torder.search_app.data.core.retrofit.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideConverterFactory(
        json: Json,
    ): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @Singleton
    fun provideNoneTokenRetrofit(
        clientBuilder: OkHttpClient.Builder,
        headerInterceptor: HeaderInterceptor,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(KAKAO_URL)
            .client(
                clientBuilder
                    .addInterceptor(headerInterceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}