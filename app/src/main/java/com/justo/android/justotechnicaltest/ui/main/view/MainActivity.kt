package com.justo.android.justotechnicaltest.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.google.gson.Gson
import com.justo.android.justotechnicaltest.R
import com.justo.android.justotechnicaltest.api.Constants.Companion.PASS_USER
import com.justo.android.justotechnicaltest.data.User
import com.justo.android.justotechnicaltest.databinding.ActivityMainBinding
import com.justo.android.justotechnicaltest.ui.detail.view.DetailsActivity
import com.justo.android.justotechnicaltest.ui.main.view.adapter.RandomUserAdapter
import com.justo.android.justotechnicaltest.ui.main.viewModel.MainViewModel
import com.justo.android.justotechnicaltest.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RandomUserAdapter.UserItemListener {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var adapter: RandomUserAdapter = RandomUserAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenCreated {
            binding.run {
                randomUserRV.adapter = adapter
                randomUserRV.layoutManager =
                    LinearLayoutManager(randomUserRV.context, VERTICAL, false)
                btnFetch.setOnClickListener {
                    mainViewModel.retrieveNewUsers()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        setupObservers()
    }

    private fun setupObservers() {
        mainViewModel.user.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) adapter.setItems(it.data)
                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    Toast.makeText(this, R.string.loading, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClickedUser(user: User) {
        val intent = Intent(applicationContext, DetailsActivity::class.java)
        val userString = Gson().toJson(user)
        intent.putExtra(PASS_USER, userString)
        if (userString.isNotEmpty()) {
            startActivity(intent)
        }
    }
}