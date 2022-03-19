package android.compose.recipeapp.network.model

import android.compose.recipeapp.domain.model.Recipe
import android.compose.recipeapp.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            description = model.description,
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,
            ingredients = model.ingredients ?: listOf(),
            cookingInstructions = model.cookingInstructions

        )
    }

    override fun mapFromDomainModel(domain: Recipe): RecipeDto {
        return RecipeDto(
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

    fun toDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map {
            mapFromDomainModel(it)
        }
    }
}