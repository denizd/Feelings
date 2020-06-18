package com.denizd.feelings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denizd.feelings.databinding.ItemEntryBinding
import com.denizd.feelings.model.Entry

class EntryAdapter(
    private var items: List<Entry> = listOf()
) : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    inner class EntryViewHolder(
        val binding: ItemEntryBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder =
        EntryViewHolder(ItemEntryBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        items[position].also { currentItem ->
            holder.binding.apply {
                feeling.text = currentItem.getEmoji(feeling.context)
                reason.text = currentItem.reason
            }
        }
    }

    fun set(items: List<Entry>) {
        this.items = items
    }
}