package com.kodesnippets.aaqib.kotlinFuel


import android.app.ProgressDialog
import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    lateinit var getData : String
    lateinit var message : TextView
    lateinit var adapter : MyAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var recycletViewAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>
    lateinit var recyclerViewLayoutManager : RecyclerView.LayoutManager
    lateinit var progressLoader : ProgressDialog

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

        progressLoader = ProgressDialog(view?.context)
        progressLoader.setMessage("Getting Posts")
        progressLoader.setProgressStyle(ProgressDialog.STYLE_SPINNER)



        message = view?.findViewById(R.id.textView1) as TextView
        message.text = getData

        recyclerView = view!!.findViewById(R.id.my_recycler_view) as RecyclerView


        recyclerViewLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = recyclerViewLayoutManager




        getPosts()
    }
    fun getPosts(){
        progressLoader.show()
        val posts = "https://jsonplaceholder.typicode.com/posts"
        NetworkConfig.getRequest(posts,success = { response ->
           progressLoader.dismiss()
            val parser = Parser()
            val stringBuilder = StringBuilder(response)
            val model = parser.parse(stringBuilder) as JsonArray<JsonObject>
            var postModel  = model.map { PostModel(it)}
            val body = postModel.map {it.body}.filterNotNull()

            this.adapter = MyAdapter(body)
            recycletViewAdapter = adapter
            recyclerView.adapter = recycletViewAdapter
            recycletViewAdapter.notifyDataSetChanged()
            adapter.onClick = { view ->

                val itemPosition = recyclerView.getChildLayoutPosition(view)
                Log.d("ITEM:POSITION",body[itemPosition])
            }

            Log.d("code",postModel.first().body)
            Log.d("Mapped::",postModel.first().title)
            Log.d("dode",postModel.first().userId.toString())
            Log.d("Mapped::",postModel.first().id.toString())

        },failure ={ error ->

        } )

    }
}// Required empty public constructor
