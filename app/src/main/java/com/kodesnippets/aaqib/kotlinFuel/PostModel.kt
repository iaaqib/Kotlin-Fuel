package com.kodesnippets.aaqib.kotlinFuel

import com.beust.klaxon.JsonObject
import com.beust.klaxon.int
import com.beust.klaxon.string
import org.json.JSONObject


/**
 * Created by silen on 7/20/2017.
 */
class PostModel {

    var id : Int? = null
    var userId : Int? = null
    var body : String? = null
    var title : String? = null


    constructor(jsonObject: JsonObject){

        id = jsonObject.int("id")
        userId = jsonObject.int("userId")
        body = jsonObject.string("body")
        title = jsonObject.string("title")
    }










}



