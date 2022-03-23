package android.compose.recipeapp.di

import android.compose.recipeapp.network.model.RecipeDtoMapper
import android.compose.recipeapp.network.responses.RecipeService
import android.compose.recipeapp.repository.RecipeRepository
import android.compose.recipeapp.repository.RecipeRepository_Impl
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
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService = recipeService, recipeDtoMapper
        )
    }

}