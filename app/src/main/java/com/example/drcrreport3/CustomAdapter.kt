package com.example.drcrreport3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*
class CustomAdapter(
    private var context: Context,
    private var account_id: ArrayList<String>,
    private var account_name: ArrayList<String>,
    private var parent_id: ArrayList<String>,
    private var parent_name: ArrayList<String>,
    private var debit: ArrayList<String>,
    private var credit: ArrayList<String>,

    ) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return  MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // set the data in items
        holder.account_id.text = account_id[position]
        holder.account_name.text = account_name[position]
        holder.parent_id.text = parent_id[position]
        holder.parent_name.text = parent_name[position]
        holder.debit.text = debit[position]
        holder.credit.text = credit[position]

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener { // display a toast with person name on item click
            Toast.makeText(context, parent_name[position], Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return parent_name.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var account_id: TextView = itemView.findViewById(R.id.tvaccount_id) as TextView
            var account_name: TextView = itemView.findViewById(R.id.tvaccount_name) as TextView
            var parent_id: TextView = itemView.findViewById(R.id.tvparent_id) as TextView
            var parent_name: TextView = itemView.findViewById(R.id.tvparent_name) as TextView
            var debit: TextView = itemView.findViewById(R.id.tvdebit) as TextView
            var credit: TextView = itemView.findViewById(R.id.tvcredit) as TextView
    }
}