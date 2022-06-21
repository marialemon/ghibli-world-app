package com.marianunez.ghibliworld.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.ghibliworld.R
import com.marianunez.ghibliworld.databinding.FragmentFilmsListBinding
import com.marianunez.ghibliworld.ui.adapter.FilmsListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstFragment : Fragment() {

    private var _binding: FragmentFilmsListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: FilmsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilmsListBinding.inflate(inflater, container, false)

        //esta es la forma nativa que ofrece android de obtener los viewmodels, sino se haría con di
        viewModel = ViewModelProvider(this)[FilmsListViewModel::class.java]

        initUI()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            viewModel.getFilmsList()
        }
    }

    private fun initUI() {
        recyclerView = binding.filmsList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = FilmsListAdapter()

        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                viewModel.getFilmsList()
            }
        }

        viewModel.filmsList.observe(viewLifecycleOwner) { list ->
            (recyclerView.adapter as FilmsListAdapter).setData(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}