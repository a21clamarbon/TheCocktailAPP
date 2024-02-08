package com.example.mycocktailapp
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/*interface CocktailServicee {
    @GET("lookup.php")
    fun getCocktailDetails(@Query("i") cocktailId: String): Call<Cocteles>
}

class DrinkDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks_list)

        val cocktailId = intent.getStringExtra("cocktailId")

        if (!cocktailId.isNullOrEmpty()) {
            getCocktailDetails(cocktailId)
        } else {
            // Manejar el caso donde el ID del cóctel es nulo o vacío
            Log.e("DrinksListActivity", "ID de cóctel nulo o vacío")
        }
    }

    private fun getCocktailDetails(cocktailId: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CocktailServicee::class.java)
        val call = service.getCocktailDetails(cocktailId)

        call.enqueue(object : Callback<Cocteles> {
            override fun onResponse(call: Call<CocktailDetails>, response: Response<CocktailDetails>) {
                if (response.isSuccessful) {
                    val cocktailDetails = response.body()
                    cocktailDetails?.let {
                        displayCocktailDetails(it)
                    }
                } else {
                    Log.e("DrinksListActivity", "Error en la solicitud: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<CocktailDetails>, t: Throwable) {
                Log.e("DrinksListActivity", "Error en la solicitud: ${t.message}")
            }
        })
    }

    private fun displayCocktailDetails(cocktailDetails: CocktailDetails) {
        val instructionsTextView: TextView = findViewById(R.id.drinkDescriptionTextView)
        instructionsTextView.text = cocktailDetails.strInstructions
    }
}
*/