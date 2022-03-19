package android.compose.recipeapp.network.responses

import android.compose.recipeapp.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>,
)