package com.justo.android.justotechnicaltest.ui.detail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.justo.android.justotechnicaltest.api.Constants.Companion.PASS_USER
import com.justo.android.justotechnicaltest.data.User
import com.justo.android.justotechnicaltest.databinding.ActivityDetailsBinding
import com.justo.android.justotechnicaltest.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    var intentFrom: Intent? = null
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        user = Gson().fromJson(intent.getStringExtra(PASS_USER),User::class.java)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenCreated {
            binding.run {
                Glide.with(binding.root.context)
                    .load(user.picture?.medium)
                    .dontAnimate()
                    .into(imgView)
                nameTxtContainer.text = user.name?.toString()
                directionTxt.text = user.location?.toString()
                loginInformationTxt.text = user.login?.toString()
                telephoneTxt.text = "Telephone Number: ${user.phone} \n Cellphone Number: ${user.cell}"
                idInformationTxt.text = user.id?.toString()
                when(user.gender) {
                    "male" -> maleImgView.visibility = View.VISIBLE
                    "female" -> femaleImgView.visibility = View.VISIBLE
                }
            }
        }
    }
}