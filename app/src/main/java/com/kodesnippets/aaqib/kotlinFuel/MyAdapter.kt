package com.kodesnippets.aaqib.kotlinFuel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by silen on 7/22/2017.
 */
class MyAdapter(dataSet: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    val dataSet : List<String> = dataSet
    final var onClick : (View)-> Unit = {}

     class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
         val textView = view.findViewById(R.id.textView_row) as TextView



    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val textView = LayoutInflater.from(parent!!.context).inflate(R.layout.recycler_view_row, parent,false)
        textView.setOnClickListener(View.OnClickListener { view ->
        this.onClick(view)
        })
        val view = ViewHolder(textView)
        return view
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {



        holder?.let { holder -> holder.textView.text = this.dataSet[position] }

    }


    override fun getItemCount(): Int {

     return  this.dataSet.size
    }



}