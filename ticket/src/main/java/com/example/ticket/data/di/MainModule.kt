package com.example.ticket.data.di

import com.example.ticket.data.mapper.DefaultDomainMapper
import com.example.ticket.data.mapper.DomainMapper
import com.example.ticket.data.remote.MainApiService
import com.example.ticket.data.repository.MainRepositoryImpl
import com.example.ticket.domain.repository.MainRepository
import com.example.ticket.domain.usecase.AllTicketsUseCase
import com.example.ticket.domain.usecase.MainUseCase
import com.example.ticket.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }

    @Provides
    fun provideDomainMapper(): DomainMapper {
        return DefaultDomainMapper() 
    }
    @Provides
    @Singleton
    fun provideRepository(apiService: MainApiService, mapper: DomainMapper): MainRepository {
        return MainRepositoryImpl(apiService, mapper)
    }
}