package com.example.maroonlabkom

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AboutMe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val actionbar = supportActionBar
        actionbar!!.title = "About Me"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgAbout: ImageView = findViewById(R.id.about)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}