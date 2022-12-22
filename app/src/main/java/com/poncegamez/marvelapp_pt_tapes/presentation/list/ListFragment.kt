package com.poncegamez.marvelapp_pt_tapes.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.poncegamez.marvelapp_pt_tapes.databinding.FragmentListBinding
import com.poncegamez.marvelapp_pt_tapes.model.Comic
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()
    private lateinit var listBinding: FragmentListBinding
    private lateinit var comicAdapter: ListComicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        addSubscriptions()
        setupAdapter()
        setUpRecyclerView()
        return listBinding.root
    }

    private fun setupAdapter() {
        comicAdapter = ListComicAdapter(onItemClicked = { onComicClicked(it) })
    }

    private fun setUpRecyclerView() {
        listBinding.comicsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = comicAdapter
            setHasFixedSize(false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getComicsFromServer()
    }

    private fun addSubscriptions() {
        viewModel.onComicsState.observe(viewLifecycleOwner) { result ->
            if (result.isNotEmpty()) {
                comicAdapter.appendItems(result)
            }
        }
    }

    private fun onComicClicked(comic: Comic) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(comic = comic))
    }

    private fun onComicsLoadedSuscribe(result: ArrayList<Comic>?) {
        result?.let { listaComics ->
            comicAdapter.appendItems(listaComics)
        }
    }
}