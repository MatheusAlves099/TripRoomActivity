package br.senai.sp.jandira.activelogintriproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.activelogintriproom.model.Category
import br.senai.sp.jandira.activelogintriproom.repository.CategoryRepository
import br.senai.sp.jandira.activelogintriproom.ui.theme.ActiveLoginTripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActiveLoginTripRoomTheme {
                HomeScreen(CategoryRepository.getCategories())
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        ActiveLoginTripRoomTheme() {
            HomeScreen(CategoryRepository.getCategories())
        }
    }

    @Composable
    fun HomeScreen(categories: List<Category>) {
        Scaffold(floatingActionButton = ) {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White)
            }
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {

                Column(modifier = Modifier.fillMaxWidth())
                {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        shape = RectangleShape
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.background_image),
                            contentDescription = "Foto de Paris",
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.height(197.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.local_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = Color.White
                                )
                                Text(
                                    text = "You're in Paris",
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                            Text(
                                text = "My Trips",
                                fontSize = 24.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 20.dp)
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
                                Image(
                                    painter = painterResource(id = R.drawable.susanna_profile),
                                    contentDescription = "",
                                    modifier = Modifier.size(61.dp)
                                )
                            }
                            Text(
                                text = "Sussana Hoffs",
                                fontSize = 12.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                    Text(
                        text = stringResource(id = R.string.categories),
                        modifier = Modifier.padding(top = 14.dp, start = 16.dp)
                    )
                    LazyRow() {
                        items(categories) { category ->
                            Card(
                                modifier = Modifier
                                    .size(110.dp, 65.dp)
                                    .padding(start = 16.dp, 4.dp),
                                backgroundColor = Color(207, 6, 240, 255)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painter = category.icon
                                            ?: painterResource(id = R.drawable.no_image),
                                        contentDescription = "",
                                        modifier = Modifier.size(32.dp),
                                        tint = Color.White
                                    )
                                    Text(
                                        text = category.name,
                                        fontSize = 12.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}