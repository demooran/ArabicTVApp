package com.example.arabictv

import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ChannelAdapter(
    private val items: List<MainActivity.Channel>,
    private val onClick: (MainActivity.Channel) -> Unit
) : RecyclerView.Adapter<ChannelAdapter.VH>() {

    class VH(val btn: Button) : RecyclerView.ViewHolder(btn)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = Button(parent.context)
        b.textSize = 14f
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.btn.text = item.name
        holder.btn.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = items.size
}
