package com.poncegamez.marvelapp_pt_tapes.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poncegamez.marvelapp_pt_tapes.R
import com.poncegamez.marvelapp_pt_tapes.databinding.CardViewComicItemBinding
import com.poncegamez.marvelapp_pt_tapes.model.Comic
import com.squareup.picasso.Picasso

class ListComicAdapter(
    private val onItemClicked: (Comic) -> Unit
) : RecyclerView.Adapter<ListComicAdapter.ComicsViewHolder>() {

    private val comicsList: ArrayList<Comic> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val binding =
            CardViewComicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val comic = comicsList[position]
        holder.itemView.setOnClickListener { onItemClicked(comic) }
        holder.bind(comic)
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

    fun appendItems(newItems: List<Comic>) {
        comicsList.clear()
        comicsList.addAll(newItems)
        notifyDataSetChanged()
    }

    class ComicsViewHolder(private val binding: CardViewComicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comic: Comic) {
            binding.nameTextView.text = comic.title
            println("${comic.thumbnailPath}.${comic.thumbnailExt}")
            val picasso = Picasso.get()
            picasso.isLoggingEnabled = true
            picasso.load("${comic.thumbnailPath}.${comic.thumbnailExt}")
                .into(binding.pictureImageView)
        }
    }
}