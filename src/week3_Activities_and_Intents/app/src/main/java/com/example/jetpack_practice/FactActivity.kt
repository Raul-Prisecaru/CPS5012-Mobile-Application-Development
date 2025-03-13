package com.example.jetpack_practice

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_practice.ui.theme.Jetpack_practiceTheme

class FactActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_practiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val listOfFacts = listOf(
                        "During the Great Depression, not a single bank in San Francisco failed. In fact, business was so good that the city constructed the Golden Gate Bridge and the Oakland Bay Bridge during the Depression.",
                        "The United Nations Charter was drafted and ratified in San Francisco in 1945.",
                        "The Beatles gave their last full concert at Candlestick Park on August 29, 1966. 25,000 tickets were sold, although the park had capacity for 42,000 people. The band played 11 songs, and lost money on the concert",
                        "The Gold Rush resulted in San Francisco’s port becoming packed with abandoned ships. With demand to build the city up, the ships were torn apart and repurposed for homes, banks, and businesses.",
                        "In 1906, three quarters of the city was destroyed by an earthquake and fire. The earthquake was the first natural disaster to be documented in photographs. The resulting fire burned for four days, and caused more than 8 billion in damage in today’s dollars.",
                        "Redwood trees helped salvage the city from the 1906 fire. Redwood has low resin content and a porous grain, which takes in lots of water. When fire reached a building made of resin, they didn’t burn as quickly.",
                        "The U.S. Navy originally planned to paint the Golden Gate Bridge black with yellow stripes. The famed “International Orange” color was intended to be a sealant.",
                        "San Francisco’s cable cars are the only National Historical Monument that can move. The cables that pull the cars run at a constant speed of 9.5 MPH.",
                        "The United States’ first Chinese immigrants came to San Francisco in 1848. Perhaps ironically, the Japanese Hagiwara family invented “Chinese” fortune cookies at the Golden Gate Park’s Tea Garden.",
                        "San Francisco resident Joshua Abraham Norton self-declared himself the Emperor of the United States. When he died, 10,000 people turned out to pay their respects."
                    )

                    FactsDisplay("Facts about San Francisco", listOfFacts, this)


                }
            }
        }
    }
}


@Composable
fun TitleDisplay(titleText: String) {

//    Spacer(modifier = Modifier.height(1000.dp))

}

@Composable
fun FactsDisplay(titleText: String, factList: List<String>, context: Context) {
    val intent = Intent(context, MainActivity2::class.java)
    var counter = 0
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp)

        ) {
        Text(
            text = titleText,
            fontSize = 40.sp,

            )
        for (fact in factList) {
            Spacer(modifier = Modifier.height(20.dp))
            counter++
            Text(
                text = "$counter. $fact",
            )
        }
        Button(onClick = {context.startActivity(intent)}) {
            Text("Go Back")
        }
    }

}