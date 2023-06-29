package com.example.maroonlabkom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maroonlabkom.databinding.ListMemberBinding


class ListMemberAdapter (private val listMember: ArrayList<Member>) : RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, note) = listMember[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener{
            val memberDetail = Intent(holder.itemView.context, DetailMember::class.java)
            memberDetail.putExtra(DetailMember.EXTRA_NAME, name)
            memberDetail.putExtra(DetailMember.EXTRA_OCCUPATION, description)
            memberDetail.putExtra(DetailMember.EXTRA_IMAGE, photo)
            memberDetail.putExtra(DetailMember.EXTRA_NOTE, note)
            holder.itemView.context.startActivity(memberDetail)
        }

    }

    override fun getItemCount(): Int = listMember.size

    class ListViewHolder(val binding: ListMemberBinding) : RecyclerView.ViewHolder(binding.root)
}