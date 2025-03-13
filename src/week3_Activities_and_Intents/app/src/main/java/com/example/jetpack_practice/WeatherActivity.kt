package com.example.jetpack_practice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_practice.GetStartedActivity.ExampleFragment
import com.example.jetpack_practice.ui.theme.Jetpack_practiceTheme
import androidx.compose.material3.Slider

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_practiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val mapDay = mapOf(
                        "Monday" to Triple(75, 52, R.drawable.sunny_icon),
                        "Tuesday" to Triple(75, 52, R.drawable.sunny_icon),
                        "Wednesday" to Triple(73, 50, R.drawable.sunny_icon),
                        "Thursday" to Triple(64, 52, R.drawable.sun_with_cloud),
                        "Friday" to Triple(64, 52, R.drawable.sun_with_cloud),
                        "Saturday" to Triple(64, 52, R.drawable.sun_with_cloud),
                        "Sunday" to Triple(64, 52, R.drawable.sun_with_cloud))
                    val mapTime = mapOf(
                        8 to "8 AM",
                        9 to "9 AM",
                        10 to "10 AM",
                        11 to "11 AM",
                        12 to "12 PM",
                        13 to "1 PM",
                        14 to "2 PM",
                        15 to "3 PM",
                        16 to "4 PM",
                        17 to "5 PM",
                    )
                    val context = LocalContext.current
                    val fragment = ExampleFragment()
                    val intent2 = Intent(this, FactActivity::class.java)
                    Column (verticalArrangement = Arrangement.spacedBy(10.dp), ){
                        CityName("San Francisco")
                        CityStatus("Mon", "12:30AM", "Mostly Sunny")
                        CityTemperature(66)

                        WindSpeed(10)
                        RainChance(10)
                        SliderTime(mapTime)

                        mapDay.forEach {(key, value) ->
                            DayTemperature(key, value.first, value.second, value.third)
                        }

                        Button(onClick = {
                            startActivity(intent2)
                        }) {
                            Text("Facts about San Francisco")
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun CityName(name: String) {
    Spacer(modifier = Modifier.height(50.dp))

    Text(
        text = name,
        fontSize = 40.sp
    )

}

@Composable
fun CityStatus(day: String, time: String, weatherStatus: String) {
    Text(
        text = "$day, $time, $weatherStatus"
    )
}


@Composable
fun CityTemperature(temperature: Number) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$temperature °F",
            fontSize = 60.sp,
        )
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.sun_with_cloud),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )

    }
}


@Composable
fun WindSpeed(windSpeed: Number) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.wind_icon),
            contentDescription = null,
            modifier = Modifier
                    .size(40.dp)
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = "$windSpeed mph",
            fontSize = 30.sp
        )
    }
}

@Composable
fun RainChance(rainChance: Number) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.cloud_rain),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(modifier = Modifier.width(30.dp))

        Text(
            text = "$rainChance %",
            fontSize = 30.sp
        )
    }
}

@Composable
fun SliderTime(timeRange: Map<Int, String>) {
    var sliderPosition by remember { mutableFloatStateOf(8f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 8,
            valueRange = 8f..17f
        )
        Text(text = timeRange.get(sliderPosition.toInt()).toString())
    }
}

@Composable
fun DayTemperature(day: String, temperature1: Number, temperature2: Number, imageLocation: Int) {
    Row {
        Text(
            text = day)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(imageLocation),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = "$temperature1° / $temperature2°"
        )

    }

}