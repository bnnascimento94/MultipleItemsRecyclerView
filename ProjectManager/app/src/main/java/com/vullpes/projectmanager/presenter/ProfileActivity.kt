package com.vullpes.projectmanager.presenter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vullpes.projectmanager.adapter.ArchiveAdapter
import com.vullpes.projectmanager.adapter.MyTeamAdapter
import com.vullpes.projectmanager.databinding.ActivityProfileBinding
import com.vullpes.projectmanager.viewModel.ProfileViewModel

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding
    val profileViewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val myTeamAdapter by lazy {MyTeamAdapter(profileViewModel.loadDataMyTeam())}

            viewTeam.apply {
                layoutManager = LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.VERTICAL,false )
                adapter = myTeamAdapter
            }

            val archiveAdapter by lazy { ArchiveAdapter(profileViewModel.loadDataArchive()) }

            viewArchives.apply {
                layoutManager = LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.HORIZONTAL, false)
                adapter = archiveAdapter
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}