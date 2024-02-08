package com.example.mycocktailapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeveloperInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.developer_info)

        showDeveloperInfo()
    }

    private fun showDeveloperInfo() {
        val name: TextView = findViewById(R.id.name)
        val linked: TextView = findViewById(R.id.linkedin)
        val copyright: TextView = findViewById(R.id.copyright)

        name.text = "Clàudia Martín"
        linked.text = "https://www.linkedin.com/in/cl%C3%A0udia-mart%C3%ADn-993933226"
        copyright.text = "Copyright ⓒ 2024-2024 TheCocktailAppClaudia. Todos los derechos reservados."
    }
}
