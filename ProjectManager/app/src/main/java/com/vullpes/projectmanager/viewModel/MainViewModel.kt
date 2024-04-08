package com.vullpes.projectmanager.viewModel

import androidx.lifecycle.ViewModel
import com.vullpes.projectmanager.repository.MainRepository

class MainViewModel(val repository: MainRepository): ViewModel() {
    constructor():this(MainRepository())

    fun loadData() = repository.items

}