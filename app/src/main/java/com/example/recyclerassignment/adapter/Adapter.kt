package com.example.recyclerassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerassignment.R
import com.example.recyclerassignment.models.TeacherItem
import kotlinx.android.synthetic.main.item_list.view.*

class Adapter : RecyclerView.Adapter<Adapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<TeacherItem>(){
        override fun areItemsTheSame(oldItem: TeacherItem, newItem: TeacherItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: TeacherItem, newItem:TeacherItem): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.profileImage).into(image)
            name.text = article.name
            subject.text = article.subjects.get(0)
            college.text = article.qualification.get(0)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}