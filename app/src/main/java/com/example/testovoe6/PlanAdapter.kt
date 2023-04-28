package com.example.testovoe6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PlanAdapter(val plans: List<Plan>) : RecyclerView.Adapter<PlanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.train_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plan = plans[position]
        holder.textViewNumber.text = (position+1).toString()
        holder.textViewTrain.text = plan.train
        holder.textViewKol.text = plan.kol
    }

    override fun getItemCount(): Int {
        return plans.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNumber: TextView = itemView.findViewById(R.id.textViewNumber)
        val textViewTrain: TextView = itemView.findViewById(R.id.textViewTrain)
        val textViewKol: TextView = itemView.findViewById(R.id.textViewKol)
    }
}