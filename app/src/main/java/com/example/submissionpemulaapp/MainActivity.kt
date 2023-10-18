package com.example.submissionpemulaapp

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionpemulaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvMusic: RecyclerView
    private val list = ArrayList<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvMusic = findViewById(R.id.rv_music)
        rvMusic.setHasFixedSize(true)

        supportActionBar?.title = "Animal APP"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.gray_dark)))

        list.addAll(getListAnimal())
        showRecyclerList()
    }

    private fun getListAnimal(): ArrayList<Animal>{
        val dataAnimal = resources.getStringArray(R.array.data_animal)
        val dataLatin = resources.getStringArray(R.array.data_latin)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val listMusic = ArrayList<Animal>()
        for (i in dataAnimal.indices){
            val music = Animal(dataAnimal[i], dataLatin[i], dataPhoto[i], dataDesc[i])
            listMusic.add(music)
        }
        return listMusic
    }

    private fun showRecyclerList(){
        rvMusic.layoutManager = LinearLayoutManager(this)
        val listAnimalAdapter = ListAnimalAdapter(list)
        rvMusic.adapter = listAnimalAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutPageActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_share -> {
                val message = "Follow my linkedin : https://www.linkedin.com/in/reynlldi/"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}