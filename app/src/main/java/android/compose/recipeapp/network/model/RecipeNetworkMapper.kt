package android.compose.recipeapp.network.model

import android.compose.recipeapp.domain.model.Recipe
import android.compose.recipeapp.domain.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<RecipeNetworkEntity, Recipe> {
    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            description = entity.description,
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated,
            ingredients = entity.ingredients ?: listOf(),
            cookingInstructions = entity.cookingInstructions

        )
    }

    override fun mapToEntity(domain: Recipe): RecipeNetworkEntity {
        return RecipeNetworkEntity(
            pk = domain.id,
            title = domain.title,
            featuredImage = domain.featuredImage,
            rating = domain.rating,
            publisher = domain.publisher,
            sourceUrl = domain.sourceUrl,
            description = domain.description,
            dateAdded = domain.dateAdded,
            dateUpdated = domain.dateUpdated,
            ingredients = domain.ingredients,
            cookingInstructions = domain.cookingInstructions

        )
    }

    fun fromEntityList(initial: List<RecipeNetworkEntity>): List<Recipe> {
        return initial.map {
            mapFromEntity(it)
        }
    }

    fun toEntityList(initial: List<Recipe>): List<RecipeNetworkEntity> {
        return initial.map {
            mapToEntity(it)
        }
    }
}