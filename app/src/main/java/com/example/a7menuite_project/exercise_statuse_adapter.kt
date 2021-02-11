package com.example.a7menuite_project

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tviteam.view.*

class exercise_statuse_adapter(val context:Context, val iteam:ArrayList<exercisemodel>) :RecyclerView.Adapter<exercise_statuse_adapter.viewholder> (){



    class viewholder (view:View):RecyclerView.ViewHolder(view){

        val tviteam = view.tviteam

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        return viewholder(LayoutInflater.from(context).inflate(R.layout.tviteam,parent,false))


    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        val model = iteam[position]

        holder.tviteam.text = model.id.toString()

        if (model.isselect){

            holder.tviteam.background = ContextCompat.getDrawable(context,R.drawable.circular_colore_exercise_background)
            holder.tviteam.setTextColor (Color.parseColor("#000000"))
        }else if (model.iscomplet){

            holder.tviteam.background = ContextCompat.getDrawable(context,R.drawable.iteam_ccircular_color_accent_background)
            holder.tviteam.setTextColor(Color.parseColor("#ffffff"))
        }else{

            holder.tviteam.background = ContextCompat.getDrawable(context,R.drawable.tviteam)
            holder.tviteam.setTextColor (Color.parseColor("#000000"))
        }
    }

    override fun getItemCount(): Int {
      return iteam.size
    }

}