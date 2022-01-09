package com.sameep.iiflassignment.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.sameep.iiflassignment.ActivityVM
import com.sameep.iiflassignment.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    companion object {

        const val KEY_ARTICLE = "ARTICLE"


    }

    private val activityViewModel by activityViewModels<ActivityVM>()
    private var _binding: FragmentArticleBinding? = null

    private val article : ArticleFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setData()

        return root
    }

    private fun setData() {

        binding.run {
            article.let {
                activityViewModel.updateTitle(it.article.title?.rendered!!)
                tvArticle.setHtmlText(it.article.content?.rendered)

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}