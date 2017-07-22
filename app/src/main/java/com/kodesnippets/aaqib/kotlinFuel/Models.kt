package com.kodesnippets.aaqib.kotlinFuel



/**
 * Created by silen on 7/20/2017.
 */
class Models {

    var id : Int? = null
    var userId : Int? = null
    var body : String? = null
    var title : String? = null

    data class PostModel(var id : Int?, var userId : Int?, var body : String? , var title : String?)

//    constructor(jsonObject: JsonObject){
//
//        id = jsonObject.int("id")
//        userId = jsonObject.int("userId")
//        body = jsonObject.string("body")
//        title = jsonObject.string("title")
//    }










}



