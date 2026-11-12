package com.example.testproject2_06_09_2026.di

import com.example.testproject2_06_09_2026.data.repository.UserRepositoryImpl
import com.example.testproject2_06_09_2026.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepositoryModule(impl: UserRepositoryImpl): UserRepository
}