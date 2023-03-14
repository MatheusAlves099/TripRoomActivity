package br.senai.sp.jandira.activelogintriproom

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.activelogintriproom.ui.theme.ActiveLoginTripRoomTheme

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
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
            )
            Column(
                modifier = Modifier.height(197.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(modifier = Modifier.padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.local_icon),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.White
                    )
                    Text(text = "You're in Paris",
                        fontSize = 14.sp,
                        color = Color.White
                        )
                }
                Text(text = "My Trips",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 36.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalAlignment = Alignment.End
            ) {
                Surface(
                    modifier = Modifier.padding(bottom = 3.dp),
                    shape = CircleShape,
                    border = BorderStroke(2.dp, color = Color.White)
                ) {
                    Image(painter = painterResource(id = R.drawable.susanna_profile),
                        contentDescription = "",
                        modifier = Modifier.size(61.dp)
                    )
                }

                Text(text = "Sussana Hoffs",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}