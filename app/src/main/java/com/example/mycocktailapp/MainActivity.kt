package com.example.mycocktailapp
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showAlcoholicDrinks(view: View) {
        startActivity(Intent(this, DrinksListActivity::class.java).putExtra("isAlcoholic", true))
    }

    fun showDeveloperInfo(view: View) {
        startActivity(Intent(this, DeveloperInfoActivity::class.java))
    }
}
