package com.google.llc.dashboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.googleandroidcodes.R
import com.google.llc.dashboard.models.TopHeadLineResponse
import javax.inject.Inject

class ItemListAdapter @Inject constructor(var context: Context) :
    RecyclerView.Adapter<ItemListAdapter.ListHolder>() {
    var articles: List<TopHeadLineResponse.Articles> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.row_item_list_layout, parent, false)
        return ListHolder(view)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        articles?.let {
            holder.txt_title.text = it.get(position).title
            holder.txt_description.text = it.get(position).author
        }
    }

    override fun getItemCount(): Int {

        return articles?.size
    }

    fun setData(list: List<TopHeadLineResponse.Articles>) {
        articles = list
        notifyDataSetChanged()
    }

    class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txt_title: TextView
        var txt_description: TextView

        init {
            txt_title = itemView.findViewById(R.id.txt_title)
            txt_description = itemView.findViewById(R.id.txt_description)
        }
    }
}