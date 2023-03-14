package br.senai.sp.jandira.activelogintriproom.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.activelogintriproom.ui.theme.ui.theme.ActiveLoginTripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActiveLoginTripRoomTheme {
                HomeScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {

    }

}