package com.vullpes.projectmanager.viewModel

import androidx.lifecycle.ViewModel
import com.vullpes.projectmanager.repository.ProfileRepository

class ProfileViewModel(val repository: ProfileRepository): ViewModel() {
    constructor():this(ProfileRepository())

    fun loadDataMyTeam() = repository.myTeamItems
    fun loadDataArchive() = repository.archiveItems
}