package com.sameep.iiflassignment.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shaadiassignment.rest.FetchService
import com.example.shaadiassignment.rest.RetrofitProvider
import com.sameep.iiflassignment.R
import com.sameep.iiflassignment.databinding.FragmentHomeBinding
import com.sameep.iiflassignment.db.ArticlesDb
import com.sameep.iiflassignment.repo.ArticlesRepo
import com.sameep.iiflassignment.rest.response.Response
import com.sameep.iiflassignment.rest.response.ResponseItem
import com.sameep.iiflassignment.ui.article.ArticleFragment
import com.sameep.iiflassignment.ui.home.adapter.ArticleAdapter
import com.sameep.iiflassignment.ui.home.adapter.HomeViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var articlesRepo: ArticlesRepo

    private val adapter = ArticleAdapter(object : ArticleAdapter.OnItemClickListener {
        override fun onItemClick(article: ResponseItem) {

            findNavController().navigate(HomeFragmentDirections.navigateToArticleFrag(article))

        }

    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        articlesRepo = ArticlesRepo(
            RetrofitProvider.retrofit!!.create(FetchService::class.java),
            ArticlesDb.getDatabase(requireContext()).articleDao(),
            requireContext().applicationContext,
        )

        homeViewModel =
            ViewModelProvider(
                viewModelStore,
                HomeViewModelFactory(articlesRepo)
            ).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initViews()
        observeData()

        return root
    }

    private fun observeData() {

        homeViewModel.observeArticlesList().observe(viewLifecycleOwner, { articles ->
            adapter.submitList(articles)
        })

    }

    private fun initViews() {

        val recyclerView: RecyclerView = binding.rvHome
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}