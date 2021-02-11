package com.example.a7menuite_project

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.iteam_history.view.*

class item_history_adapter(val context:Context,val items:ArrayList<String>):RecyclerView.Adapter<item_history_adapter.viewholer>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholer {

        return viewholer(LayoutInflater.from(context).inflate(R.layout.iteam_history,parent,false))

    }

    override fun onBindViewHolder(holder: viewholer, position: Int) {

        val date = items[position]

        holder.tvposition.text = (position + 1).toString()
        holder.tvitem.text = date
        val llitemss = holder.llitems

        if (position %2 == 0){

            llitemss.setBackgroundColor(Color.parseColor("#E9F4F2"))

        }else{

            llitemss.setBackgroundColor(Color.WHITE)
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class viewholer (view:View):RecyclerView.ViewHolder(view){

        val tvposition = view.tv_opsition
        val tvitem = view.tv_iteam
        val llitems = view.llitems

    }

}