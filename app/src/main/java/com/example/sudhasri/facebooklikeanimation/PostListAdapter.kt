package com.example.sudhasri.facebooklikeanimation

import android.support.v4.app.DialogFragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_view.view.*

class PostListAdapter(val source : List<String>, val onItemClickListener: OnItemClickListener?) : RecyclerView.Adapter<PostListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int = source.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = source[position]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.text
        init{
            itemView.setOnClickListener {
                onItemClickListener?.onItemClick()
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick()
    }
}
