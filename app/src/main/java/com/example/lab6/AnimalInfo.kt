package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val name= intent.extras?.getString("name")
        val des= intent.extras?.getString("des")
        val image= intent.extras?.getInt("image")
        val vImage:ImageView=findViewById(R.id.image)
        val vName:TextView=findViewById(R.id.Name)
        val vDes:TextView=findViewById(R.id.Des)

        vImage.setImageResource(image!!)
        vName.text=name
        vDes.text=des
    }
}