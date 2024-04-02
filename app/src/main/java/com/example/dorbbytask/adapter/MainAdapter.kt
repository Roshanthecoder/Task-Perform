package com.example.dorbbytask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dorbbytask.databinding.ItemTitleBinding
import com.example.dorbbytask.models.AuthorResultItem
import com.example.dorbbytask.utils.ClickEventType
import com.example.dorbbytask.utils.ImageLoad

class MainAdapter(private var list: ArrayList<AuthorResultItem>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var onItemClick: ((ClickEventType, AuthorResultItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (ClickEventType, AuthorResultItem) -> Unit) {
        onItemClick = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(arrayList: ArrayList<AuthorResultItem>) {
        this.list = arrayList
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.cardClick.setOnClickListener {
                onItemClick?.invoke(ClickEventType.ITEM_CLICK, list[adapterPosition])
            }
        }

        fun bind(item: AuthorResultItem) {
            binding.titleTextView.text = item.name
            ImageLoad.loadImage(binding.root.context, item.avatar, binding.profImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val laybinding =
            ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(laybinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}