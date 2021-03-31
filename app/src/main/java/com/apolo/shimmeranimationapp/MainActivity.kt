package com.apolo.shimmeranimationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        findViewsId()
        setupRecyclerView()
        setupShimmerAnimationListener()

    }

    private fun findViewsId() {
        recyclerView = findViewById(R.id.itens_list)
        itemsShimmer = findViewById(R.id.items_shimmer)
        startStopAnimation = findViewById(R.id.start_stop_animation)
    }

    private fun setupShimmerAnimationListener() {
        startStopAnimation.setOnClickListener {
            if (itemsShimmer.isShimmerStarted) {
                startStopAnimation.text = getString(R.string.animation_start_title)
                itemsShimmer.stopShimmer()
                itemsShimmer.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE

            } else {
                startStopAnimation.text = getString(R.string.animation_stop_title)
                itemsShimmer.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
                itemsShimmer.startShimmer()
            }
        }
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
          addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
          layoutManager = LinearLayoutManager(this@MainActivity)
          adapter = AnimalsAdapter(MockAnimals.getAnimals())
        }

    }
}