package com.apolo.shimmeranimationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView : RecyclerView
    lateinit var itemsShimmer : ShimmerFrameLayout
    lateinit var startStopAnimation : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById<RecyclerView>(R.id.itens_list)
        itemsShimmer = findViewById<ShimmerFrameLayout>(R.id.items_shimmer)
        startStopAnimation = findViewById<TextView>(R.id.start_stop_animation)
        itemsShimmer.startShimmer()

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(this)

        Handler().postDelayed({
            itemsShimmer.stopShimmer()
            itemsShimmer.visibility = View.GONE
            recyclerView.adapter = AnimalsAdapter(MockAnimals.getAnimals())
        },8000)

        startStopAnimation.setOnClickListener {
            if (itemsShimmer.isShimmerStarted){
                startStopAnimation.text = "Clique para iniciar a animação"
                itemsShimmer.stopShimmer()
                itemsShimmer.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE

            } else {
                startStopAnimation.text = "Clique para pausar a animação"
                itemsShimmer.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
                itemsShimmer.startShimmer()
            }
        }

    }
}