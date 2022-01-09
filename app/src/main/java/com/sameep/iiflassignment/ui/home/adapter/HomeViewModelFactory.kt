package com.sameep.iiflassignment.ui.home.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.sameep.iiflassignment.repo.ArticlesRepo
import com.sameep.iiflassignment.ui.home.HomeViewModel

class HomeViewModelFactory(val repo: ArticlesRepo) : NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repo = repo) as T
    }
}