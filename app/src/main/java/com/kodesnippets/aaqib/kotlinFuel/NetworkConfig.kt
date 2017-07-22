package com.kodesnippets.aaqib.kotlinFuel

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import org.json.JSONArray
import org.json.JSONObject


/**
 * Created by silen on 7/18/2017.
 */
object NetworkConfig {

    fun getRequest(url: String, success: (String) -> Unit, failure: (FuelError) -> Unit) {

        Fuel.get(url).responseString { request, response, result ->

            val (data, error) = result
            if (error != null) {
                Log.v("Error", error!!.toString())
                failure(error)
            } else {
                val onSuccess = data ?: return@responseString
                success(onSuccess)
//                if (onSuccess.array() is JSONArray) {
//                    //    success(onSuccess.array())
//                } else if (onSuccess.obj() is JSONObject) {
//                    //   success(onSuccess.obj())
//                }

            }

        }
    }






}