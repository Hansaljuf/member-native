package com.example.maroonlabkom

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maroonlabkom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mlMember.setHasFixedSize(true)

        list.addAll(getListMember())
        showTheList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getListMember(): ArrayList<Member> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataNote = resources.getStringArray(R.array.data_note)
        val listMember = ArrayList<Member>()
        for (i in dataName.indices){
            val member = Member(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataNote[i])
            listMember.add(member)
        }
        return listMember
    }

    private fun showTheList(){
        binding.mlMember.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdapter(list)
        binding.mlMember.adapter = listMemberAdapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about -> {
                val iAbout = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(iAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

