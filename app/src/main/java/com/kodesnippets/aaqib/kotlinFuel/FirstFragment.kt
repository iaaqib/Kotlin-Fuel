package com.kodesnippets.aaqib.kotlinFuel


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    lateinit var getData : String
    lateinit var message : TextView

    lateinit var recyclerView : RecyclerView
    lateinit var recycletViewAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>
    lateinit var recyclerViewLayoutManager : RecyclerView.LayoutManager


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Log.d("Data",this.getData)
        Log.v("Data",this.getData)

        // use a linear layout manager


        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view?.findViewById(R.id.textView1) as TextView
        message.text = getData

        recyclerView = view!!.findViewById(R.id.my_recycler_view) as RecyclerView


        recyclerViewLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = recyclerViewLayoutManager

        val list = arrayListOf("ABCEd","Hello","World","From the outside")
        val adapter = MyAdapter(list)
        recycletViewAdapter = adapter
        recyclerView.adapter = recycletViewAdapter

        adapter.onClick = { view ->

            val itemPosition = recyclerView.getChildLayoutPosition(view)
            Log.d("ITEM:POSITION",list[itemPosition])
        }
    }
}// Required empty public constructor
