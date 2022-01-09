package com.sameep.iiflassignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityVM : ViewModel() {

    private val toolbarTitle = MutableLiveData<String>()

    fun observeTitle() = toolbarTitle

    fun updateTitle(title : String) = toolbarTitle.postValue(title)

}