package android.compose.recipeapp.repository

import android.compose.recipeapp.domain.model.Recipe
import android.compose.recipeapp.network.model.RecipeDtoMapper
import android.compose.recipeapp.network.responses.RecipeService

class RecipeRepository_Impl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }

}