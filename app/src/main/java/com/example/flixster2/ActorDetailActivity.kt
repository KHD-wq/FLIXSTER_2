package com.example.flixster2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ActorDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_detail)

        val name = intent.getStringExtra("ACTOR_NAME")
        val profilePath = intent.getStringExtra("ACTOR_PROFILE_PATH")
        val knownFor = intent.getStringExtra("ACTOR_KNOWN_FOR")
        val posterPath = intent.getStringExtra("ACTOR_POSTER_PATH")
        val description = intent.getStringExtra("ACTOR_DESCRIPTION")

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val profileImageView: ImageView = findViewById(R.id.profileImageView)
        val knownForTextView: TextView = findViewById(R.id.knownForTextView)
        val posterImageView: ImageView = findViewById(R.id.posterImageView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        val backButton: Button = findViewById(R.id.backButton)

        nameTextView.text = name
        knownForTextView.text = knownFor
        descriptionTextView.text = description
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500$profilePath")
            .into(profileImageView)
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500$posterPath")
            .into(posterImageView)

        backButton.setOnClickListener {
            finish()
        }
    }
}
