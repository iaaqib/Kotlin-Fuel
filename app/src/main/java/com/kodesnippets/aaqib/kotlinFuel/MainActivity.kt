package com.kodesnippets.aaqib.kotlinFuel

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.readValues

import org.json.JSONArray


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    val first = FirstFragment()
    val second = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        first.getData = ""
        supportFragmentManager.beginTransaction().replace(R.id.fragment, first).commit();

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)











/*        val posts = "https://jsonplaceholder.typicode.com/posts"
        NetworkConfig.getRequest(posts,success = { response ->

         //   if (response is JSONArray){
            val jsonArray = response
     //       val mapper = jacksonObjectMapper()
       //         val state  = mapper.readValue<Models.PostModel>(response)
       //     Log.d("Mode;",state.title)
       //     Log.d("Mapped::",state.body)

//                for (item in 0..(jsonArray.length() - 1)) {
//                val getJSONObject = jsonArray.getJSONObject(item)
//                Log.d("UserID", getJSONObject["userId"].toString())
//                Log.d("Title", getJSONObject["title"].toString())
//                Log.d("Body", getJSONObject["body"].toString())
//                Toast.makeText(this,getJSONObject["title"].toString(),Toast.LENGTH_LONG).show()
//
//           // }
//        }
        },failure ={ error ->

        } )*/

    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                first.getData = "I am BATMAN!"
                supportFragmentManager.beginTransaction().replace(R.id.fragment, first).commit()

            }
            R.id.nav_gallery -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment, second).commit()
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}


