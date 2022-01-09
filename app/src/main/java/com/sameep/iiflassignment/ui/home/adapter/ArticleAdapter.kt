package com.sameep.iiflassignment.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sameep.iiflassignment.rest.response.Response
import com.sameep.iiflassignment.rest.response.ResponseItem
import com.sameep.iiflassignment.ui.home.adapter.viewholders.ArticleViewHolder

class ArticleAdapter(private val onItemClickList: OnItemClickListener) :
    RecyclerView.Adapter<ArticleViewHolder>() {

    private var articleList = mutableListOf<ResponseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder.create(parent)
        }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                onItemClickList.onItemClick(articleList[position])
            }

        })
    }

    override fun getItemCount(): Int {
        return articleList.size
    }


    fun submitList(it: List<ResponseItem>?) {
        articleList = if (!it.isNullOrEmpty()) it.toMutableList() else mutableListOf()
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(response: ResponseItem)
    }

}