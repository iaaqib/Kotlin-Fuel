package com.kodesnippets.aaqib.kotlinFuel


import android.os.Bundle
import android.support.v4.app.Fragment
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
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Log.d("Data",this.getData)
        Log.v("Data",this.getData)


        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view?.findViewById(R.id.textView1) as TextView
        message.text = getData



    }
}// Required empty public constructor
