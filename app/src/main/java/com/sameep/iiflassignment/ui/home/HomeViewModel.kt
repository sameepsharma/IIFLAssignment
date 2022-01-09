package com.sameep.iiflassignment.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sameep.iiflassignment.repo.ArticlesRepo
import com.sameep.iiflassignment.rest.response.Response
import com.sameep.iiflassignment.rest.response.ResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    val repo: ArticlesRepo
) : ViewModel() {

    private var _articlesLiveData = MutableLiveData<List<ResponseItem>>(mutableListOf())

    init {
        viewModelScope.launch(Dispatchers.Default) {
            _articlesLiveData.postValue(repo.getArticles().filterNotNull())
        }
    }

    fun observeArticlesList() = _articlesLiveData

}