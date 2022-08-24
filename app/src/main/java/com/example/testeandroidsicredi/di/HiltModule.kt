package com.example.testeandroidsicredi.di

import com.example.testeandroidsicredi.repository.EventRepository
import com.example.testeandroidsicredi.service.EventAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://5f5a8f24d44d640016169133.mockapi.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun provideEvent(retrofit: Retrofit): EventAPI = retrofit.create(EventAPI::class.java)

    @Provides
    fun provideEventRepository(service: EventAPI): EventRepository =
        EventRepository(service)
}