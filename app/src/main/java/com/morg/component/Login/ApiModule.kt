import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideLoginRepository(service: LoginService, dao: LoginDao): LoginRepository {
        return LoginRepository(service, dao)
    }
}