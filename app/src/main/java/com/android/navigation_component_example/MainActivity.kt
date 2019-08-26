package com.android.navigation_component_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            title = destination.label
            if(destination.id == R.id.homeFragment) {
                Log.d("addOnChangedListener", "homeFragment")
            } else {
                Log.d("addOnChangedListener", "OtherFragment")
            }
        }
    }
}
