package com.example.mycocktailapp
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import java.io.Serializable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

data class Cocktail(val idDrink: String, val strDrink: String, val strDrinkThumb: String)

data class Cocteles(val drinks: List<Cocktail>)
data class CocktailDetails(val strInstructions: String)

interface CocktailService {
    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicDrinks(): Call<Cocteles>

    @GET("lookup.php")
    fun getCocktailDetails(@Query("i") cocktailId: String): Call<Cocteles>
}

class DrinksListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks_list)

        showAlcoholicDrinks()
    }

    private fun showAlcoholicDrinks() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CocktailService::class.java)
        val call = service.getAlcoholicDrinks()

        call.enqueue(object : Callback<Cocteles> {
            override fun onResponse(call: Call<Cocteles>, response: Response<Cocteles>) {
                if (response.isSuccessful) {
                    val cocteles = response.body()
                    cocteles?.let {
                        mostrarListaEnListView(it.drinks)
                        println("Conexión exitosa")
                    }
                } else {
                    println("Error en la solicitud. ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Cocteles>, t: Throwable) {
                println("Error en la solicitud. ${t.message}")
            }
        })
    }

    private fun mostrarListaEnListView(drinksList: List<Cocktail>) {
        val listView: ListView = findViewById(R.id.listView)
        val adapter = DrinksAdapter(this, drinksList)
        listView.adapter = adapter
        }
    }

class DrinksAdapter(private val context: Context, private val drinksList: List<Cocktail>) : ArrayAdapter<Cocktail>(context, R.layout.list_item_drink, drinksList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.list_item_drink, parent, false)
        }

        val imageView: ImageView = itemView!!.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)

        val drink = drinksList[position]

        // Load the image using Glide
        Glide.with(context)
            .load(drink.strDrinkThumb)
            .into(imageView)

        // Log the drink name to check if it's not null
        Log.d("DrinkName", drink.strDrink)

        textView.text = drink.strDrink


        return itemView
    }
}

