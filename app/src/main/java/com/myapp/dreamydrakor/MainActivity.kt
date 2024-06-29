package com.myapp.dreamydrakor

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  rvDrama: RecyclerView
    private val list = ArrayList<Drama>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDrama = findViewById(R.id.rv_drama)
        rvDrama.setHasFixedSize(true)

        list.addAll(getListDramas())
        showRecyclerList()
    }

    private fun getListDramas(): ArrayList<Drama>{
        val listName = resources.getStringArray(R.array.list_name)
        val listDescription = resources.getStringArray(R.array.list_description)
        val listImage = resources.obtainTypedArray(R.array.list_image)
        val listDrama = ArrayList<Drama>()
        for (i in listName.indices) {
            val drama = Drama(listName[i], listDescription[i], listImage.getResourceId(i, -1))
            listDrama.add(drama)
        }
        listImage.recycle()

        return listDrama
    }

    private fun showRecyclerList(){
        rvDrama.layoutManager = LinearLayoutManager(this)
        val listDramaAdapter = ListDramaAdapter(list)
        rvDrama.adapter = listDramaAdapter

        listDramaAdapter.setOnItemClickCallback(object: ListDramaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Drama) {
                showSelectedDrama(data)
            }
        })
    }

    private fun showSelectedDrama(drama: Drama) {
        Toast.makeText(this, "Anda memilih ${drama.title}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.about_page){
            startActivity(Intent(this, AboutActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}