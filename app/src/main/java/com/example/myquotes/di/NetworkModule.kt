package com.example.myquotes.di

import androidx.compose.foundation.text.BasicText

import com.example.myquotes.Network.Base_URL
import com.example.myquotes.data.remote.AppInterFace
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule  {

    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseUrl():String = Base_URL



@Singleton
@Provides
fun getRetrofitClient(
    @Named("base_url") baseurl :String
):Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseurl)
    .build()


    @Singleton
    @Provides
    fun getApiClient(
        retrofit: Retrofit
    ):AppInterFace = retrofit.create(AppInterFace::class.java)
}