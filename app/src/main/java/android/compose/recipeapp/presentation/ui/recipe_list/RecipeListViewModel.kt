package android.compose.recipeapp.presentation.ui.recipe_list

import android.compose.recipeapp.repository.RecipeRepository
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Named


class RecipeListViewModel
@ViewModelInject
constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    private @Named("auth_token") val token: String
) : ViewModel() {
    private val TAG = "RecipeListViewModel"

    init {
        Log.d(TAG, ": $randomString")
        Log.d(TAG, ": $token")
        Log.d(TAG, ": $repository")
    }
}