package com.example.myquotes.di

import com.example.myquotes.data.remote.AppInterFace
import com.example.myquotes.data.repositoryImpl.QuoteRepositoryImpl
import com.example.myquotes.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun  getQuotesRepository(
        appInterFace: AppInterFace
    ):QuoteRepository=QuoteRepositoryImpl(appInterFace = appInterFace)
}