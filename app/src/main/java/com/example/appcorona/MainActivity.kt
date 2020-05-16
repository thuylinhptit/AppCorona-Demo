package com.example.appcorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val vm : MainViewModel by viewModels(factoryProducer = {
        ViewModelFactory()
    })

    lateinit var adapterCorona: CoronaListAdapter
    lateinit var loadingView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcv = findViewById<RecyclerView>(R.id.rcv)
        loadingView = findViewById(R.id.loading_view)

        adapterCorona = CoronaListAdapter(this)
        rcv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterCorona
        }
    }

    override fun onResume() {
        super.onResume()

        vm.listCorona.observe(this, Observer {
            adapterCorona.submitList(it)
        })

        vm.isLoading.observe(this, Observer {
            loadingView.visibility = if (it) View.VISIBLE else View.GONE
        })

        vm.isError.observe(this, EventObserver {
            if (it) Toast.makeText(this, "Network error!", Toast.LENGTH_LONG).show()
        })
    }
}
