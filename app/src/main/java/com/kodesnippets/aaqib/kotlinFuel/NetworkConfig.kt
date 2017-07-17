package com.kodesnippets.aaqib.kotlinFuel

import android.util.Log
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet


/**
 * Created by silen on 7/18/2017.
 */
object NetworkConfig {

     fun getRequest(url:String, success:(String)->Unit, failure: (FuelError)->Unit){

      url.httpGet().responseString{request, response, result ->

          val (data, error) = result
         if (error != null){
             Log.v("Error",error!!.toString())
             failure(error)
         }else{
             val onSuccess = data ?: return@responseString
            success(onSuccess)

         }

      }



    }




}