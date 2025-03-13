package com.example.listandadapterweek5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val sampleNames = listOf(
    "James",
    "Michael",
    "Robert",
    "John",
    "David",
    "William",
    "Richard",
    "Joseph",
    "Thomas",
    "Christopher",
    "Charles",
    "Daniel",
    "Matthew",
)

val sampleRelationships = listOf(
    "Wife",
    "Husband",
    "Son",
    "Guest",
    "Neighbour",
    "Mother",
    "Father",
    "Sister",
    "Brother",
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val contacts = mutableListOf<Contact>()
        for (num in 1..20) {
            contacts.add(Contact(
                sampleNames.random(),
                phoneNumber = (1_000_000_000L..9_999_999_999L).random().toString(),
                relationship = sampleRelationships.random()
            ))
        }


        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, ProfileViewer::class.java)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactAdapter(contacts) { contact ->
            println("Name: " + contact.name)
            intent.putExtra("name", contact.name)
            intent.putExtra("phoneNumber", contact.phoneNumber)
            intent.putExtra("description", contact.relationship)
            startActivity(intent)
        }
    }
}

@Composable
fun addNewUser() {
    
}