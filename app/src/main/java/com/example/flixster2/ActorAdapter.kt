package com.example.flixster2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ActorAdapter(private val actors: List<Actor>) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val profileImageView: ImageView = view.findViewById(R.id.profileImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_item, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = actors[position]
        holder.nameTextView.text = actor.name
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + actor.profile_path)
            .into(holder.profileImageView)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ActorDetailActivity::class.java).apply {
                putExtra("ACTOR_NAME", actor.name)
                putExtra("ACTOR_PROFILE_PATH", actor.profile_path)
                putExtra("ACTOR_KNOWN_FOR", actor.known_for[0].title)
                putExtra("ACTOR_POSTER_PATH", actor.known_for[0].poster_path)
                putExtra("ACTOR_DESCRIPTION", actor.known_for[0].overview)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = actors.size
}
