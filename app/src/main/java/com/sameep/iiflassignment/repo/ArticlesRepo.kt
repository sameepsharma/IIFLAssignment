package com.sameep.iiflassignment.repo

import android.content.Context
import android.util.Log
import com.example.shaadiassignment.rest.FetchService
import com.sameep.iiflassignment.db.dao.ArticlesDao
import com.sameep.iiflassignment.rest.response.ResponseItem
import com.sameep.iiflassignment.utils.isInternetAvailable

class ArticlesRepo(
    val fetchService: FetchService,
    val articlesDao: ArticlesDao,
    val context: Context,
) {

suspend fun getArticles() : List<ResponseItem?>{

    return if(context.isInternetAvailable()){
        val articlesNw = fetchService.getArticles()
        articlesDao.insertArticles(articlesNw)
            return (articlesNw)
    }
    else {
        val dbItems = articlesDao.getSavedArticles()
        return dbItems
    }

}

}