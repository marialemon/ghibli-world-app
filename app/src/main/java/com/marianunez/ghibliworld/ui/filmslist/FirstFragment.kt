package com.marianunez.ghibliworld.ui.filmslist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.ghibliworld.R
import com.marianunez.ghibliworld.databinding.FragmentFilmsListBinding
import com.marianunez.ghibliworld.domain.model.FilmsModel
import com.marianunez.ghibliworld.ui.filmdetail.FilmDetailActivity
import com.marianunez.ghibliworld.ui.filmslist.adapter.FilmsListAdapter
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
        viewModel =
            ViewModelProvider(this)[FilmsListViewModel::class.java] //forma nativa que ofrece android de obtener los viewmodels, sino se haría con di
        initUI()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun initUI() {
        recyclerView = binding.filmsList
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = FilmsListAdapter { goToDetail(it) }

        /**
         * https://dev.to/saketh/why-using-globalscope-is-discouraged-in-kotlin-coroutines-33hc
         * GlobalScope o lifecycleScope
         * GlobalScope sigue llamandose hasta que la app muera, aunque cambies de activity
         * viewLifecycleOwner se pone porque es un fragment, en una activity no se pone
         */
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                viewModel.getFilmsList()
            }
        }
        setUpObservers()
    }

    fun setUpObservers() {
        /**
         * al observer se le pasa el viewLifecycleOwner porque lo que se ejecuta afecta a la vista del fragment
         * y si no se vincula con el ciclo de vida de la propia vista, puede haber errores
         * en los fragments hay dos ciclos de vida, el del fragment en sí y el de su vista
         * la vista se destruye cuando el user pasa a otra aunque el fragment propio no se destruya
         * por esto también hay que configurar los observers en el onCreateView
         */
        viewModel.filmsList.observe(viewLifecycleOwner) { list ->
            (recyclerView.adapter as FilmsListAdapter).setData(list)
        }
    }

    private fun goToDetail(filmsModel: FilmsModel) {
        startActivity(Intent(context, FilmDetailActivity::class.java).apply {
            putExtra("Title", filmsModel.title)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}