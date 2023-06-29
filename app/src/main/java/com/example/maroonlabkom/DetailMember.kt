package com.example.maroonlabkom

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.maroonlabkom.databinding.ActivityDetailMemberBinding


class DetailMember : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Member"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val gImage = intent.getIntExtra(EXTRA_IMAGE,0)
        val gName = intent.getStringExtra(EXTRA_NAME)
        val gOccupation = intent.getStringExtra(EXTRA_OCCUPATION)
        val gNote = intent.getStringExtra(EXTRA_NOTE)

        binding.imgMember.setImageResource(gImage)
        binding.memberName.text = gName
        binding.memberDetail.text = gOccupation
        binding.isiNote.text = gNote
    }

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OCCUPATION = "extra_occupation"
        const val EXTRA_NOTE = "extra_note"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}