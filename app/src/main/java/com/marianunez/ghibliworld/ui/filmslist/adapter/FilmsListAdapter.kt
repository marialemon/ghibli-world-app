package com.marianunez.ghibliworld.ui.filmslist.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.ghibliworld.R
import com.marianunez.ghibliworld.commons.inflate
import com.marianunez.ghibliworld.commons.loadImageByUrl
import com.marianunez.ghibliworld.databinding.FilmItemBinding
import com.marianunez.ghibliworld.domain.model.FilmsModel

class FilmsListAdapter(private val listener: (FilmsModel) -> Unit) :
    RecyclerView.Adapter<FilmsListViewHolder>() {

    private var filmList: List<FilmsModel> = emptyList()
    fun setData(list: List<FilmsModel>) {
        filmList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsListViewHolder {
        val adapterLayout = parent.inflate(R.layout.film_item)
        return FilmsListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FilmsListViewHolder, position: Int) {
        val item = filmList[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int = filmList.size
}

class FilmsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = FilmItemBinding.bind(view)

    fun bind(item: FilmsModel, listener: (FilmsModel) -> Unit) {
        with(binding) {
            filmTitle.text = item.title
            filmImg.loadImageByUrl(item.movieBanner)
            itemView.setOnClickListener { listener(item) }
        }
    }
}