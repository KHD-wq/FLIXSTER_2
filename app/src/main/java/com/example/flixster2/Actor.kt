package com.example.flixster2


data class Actor(
    val id: Int,
    val name: String,
    val profile_path: String,
    val known_for: List<Movie>,
    val biography: String,
    val birthday: String,
    val place_of_birth: String
)

data class Movie(
    val title: String,
    val poster_path: String,
    val overview: String
)
