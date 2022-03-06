package android.compose.recipeapp

import android.compose.recipeapp.network.responses.RecipeService
import android.compose.recipeapp.ui.theme.RecipeAppTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mapper = RecipeNetworkMapper()
//        val recipe = Recipe()
//        val networkEntity: RecipeNetworkEntity = mapper.mapToEntity(recipe)
//        val r = mapper.mapFromEntity(networkEntity )

        val service = Retrofit.Builder().baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(RecipeService::class.java)

        CoroutineScope(IO).launch {
            val response = service.get(token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48", id = 583)

            Log.d("MainActivity", "onCreate: ${response.title}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeAppTheme {

    }
}