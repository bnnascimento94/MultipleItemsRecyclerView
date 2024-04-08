package com.vullpes.projectmanager.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.vullpes.projectmanager.R
import com.vullpes.projectmanager.adapter.OngoingAdapter
import com.vullpes.projectmanager.databinding.ActivityMainBinding
import com.vullpes.projectmanager.viewModel.MainViewModel

class DashBoardActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val ongoingAdapter by lazy{OngoingAdapter(mainViewModel.loadData())}

            viewOngoing.apply {
                layoutManager = GridLayoutManager(this@DashBoardActivity, 2)
                adapter = ongoingAdapter
            }

            menuProfile.setOnClickListener {
                startActivity(Intent(this@DashBoardActivity,ProfileActivity::class.java))
            }
        }
    }
}