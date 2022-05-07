package net.subroh0508.mppsample

import android.os.Bundle
import net.subroh0508.Greeting
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text


fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(greet())
        }
    }
}
