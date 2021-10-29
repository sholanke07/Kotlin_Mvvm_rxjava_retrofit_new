package com.lateef.kotlinrxjava_retrofit_mvvm_new.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Model.PostModel
import com.lateef.kotlinrxjava_retrofit_mvvm_new.R
import kotlinx.android.synthetic.main.layout_post_items.view.*
import java.lang.StringBuilder

class PostListAdapter(var context: Context, var postModelList: MutableList<PostModel>): RecyclerView.Adapter<PostListAdapter.MyViewHoder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapter.MyViewHoder {
        return MyViewHoder(LayoutInflater.from(context).inflate(R.layout.layout_post_items, parent, false))
    }

    override fun onBindViewHolder(holder: PostListAdapter.MyViewHoder, position: Int) {
        holder.txtTitle.text = postModelList[position].title.toString()
        holder.txtBody.text = StringBuilder(postModelList[position].body!!.substring(0, 20))
            .append("...").toString()
        holder.txtUserId.text = postModelList[position].userId.toString()
    }

    override fun getItemCount(): Int {
        return postModelList.size
    }

   inner class MyViewHoder(itemView: View): RecyclerView.ViewHolder(itemView) {

       var txtUserId = itemView.txtUserId
       var txtBody = itemView.txtBody
       var txtTitle = itemView.txtTitle

       init {

       }
    }
}