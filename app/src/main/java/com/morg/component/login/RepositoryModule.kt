package com.morg.component.login

import com.morg.component.login.screen.UserRepository
import com.morg.component.login.screen.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideUserRepository(
        service: UserService
    ): UserRepository {
        return UserRepository(service)
    }
}