 package com.example.flixster2

 import android.os.Bundle
 import androidx.appcompat.app.AppCompatActivity
 import androidx.lifecycle.lifecycleScope
 import androidx.recyclerview.widget.LinearLayoutManager
 import androidx.recyclerview.widget.RecyclerView
 import kotlinx.coroutines.launch

 class MainActivity : AppCompatActivity() {

     private lateinit var recyclerView: RecyclerView
     private lateinit var adapter: ActorAdapter

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         recyclerView = findViewById(R.id.recyclerView)
         recyclerView.layoutManager = LinearLayoutManager(this)

         lifecycleScope.launch {
             try {
                 val actorResponse = RetrofitInstance.api.getPopularActors("6c4e104af64b2de07bd1f740e3c2de4b")
                 adapter = ActorAdapter(actorResponse.results)
                 recyclerView.adapter = adapter
             } catch (e: Exception) {
                 e.printStackTrace()
             }
         }
     }
 }
