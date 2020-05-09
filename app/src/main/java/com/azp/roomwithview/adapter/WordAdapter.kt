package com.azp.roomwithview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azp.roomwithview.R
import com.azp.roomwithview.entity.Word
import kotlinx.android.synthetic.main.item_word.view.*

class WordAdapter(context: Context) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var words = emptyList<Word>()

    inner class WordViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(word: Word){
            itemView.txtWord.text = word.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word,
                parent,false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("Word size>>>>>", words.size.toString())
        return words.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    fun setWords(words: List<Word>){
        this.words = words
        notifyDataSetChanged()
    }
}