package com.sameep.iiflassignment.ui.home.adapter.viewholders

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sameep.iiflassignment.R
import com.sameep.iiflassignment.databinding.ArticleItemBinding
import com.sameep.iiflassignment.rest.response.ResponseItem
import com.sameep.iiflassignment.utils.inflate

class ArticleViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val binding= ArticleItemBinding.bind(itemView)

    companion object {
        const val LAYOUT_ID = R.layout.article_item

        fun create(
            parent: ViewGroup,
        ): ArticleViewHolder {
            val view = parent.inflate(LAYOUT_ID, false)
            return ArticleViewHolder(view)
        }
    }

    fun bind(item : ResponseItem){

        binding.run {
            itemTvTitle.text = item.title?.rendered
            itemTvExcerpt.setHtmlText(item.excerpt?.rendered)
        }

    }

}