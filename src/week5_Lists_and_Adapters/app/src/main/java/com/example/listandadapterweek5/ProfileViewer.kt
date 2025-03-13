package com.example.listandadapterweek5

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.listandadapterweek5.databinding.ActivityProfileViewerBinding

class ProfileViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        val name = getIntent().getStringExtra("name").toString() ?: "Null"
        println(name)
        val phoneNumber = getIntent().getStringExtra("phoneNumber") ?: "Null"
        val description = getIntent().getStringExtra("description") ?: "Null"

        setContent {
            Column {
                DisplayName(name)
                DisplayPhoneNumber(phoneNumber)
                DisplayDescription(description)
                Button(onClick = {startActivity(intent)}) {
                    Text(
                        text = "Go Back"
                    )
                }

            }
        }
    }

}


@Composable
fun DisplayName(name: String) {
    Text(

        text = "Name: $name",
        fontSize = 60.sp,
        modifier = Modifier
            .padding(top = 50.dp)
            .padding(bottom = 10.dp)


    )
}


@Composable
fun DisplayPhoneNumber(phoneNumber: String) {
    Text(

        text = "Phone Number: $phoneNumber",
        fontSize = 30.sp,

    )
}

@Composable
fun DisplayDescription(description: String) {
    Text(
        text = "Description: $description",
        fontSize = 20.sp,
        modifier = Modifier
            .padding(bottom = 10.dp)
    )
}

