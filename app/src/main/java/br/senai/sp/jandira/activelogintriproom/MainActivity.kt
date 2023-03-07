package br.senai.sp.jandira.activelogintriproom

import android.graphics.fonts.Font
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.activelogintriproom.ui.theme.ActiveLoginTripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActiveLoginTripRoomTheme() {
                LoginScreen()
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun LoginScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Row(
            horizontalArrangement = Arrangement.End,
        ) {

            Surface(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(bottomStart = 16.dp),
                color = Color(207, 6, 240, 255)
            ) {

            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.text_login),
                fontSize = 48.sp,
                color = Color(207, 6, 240, 255),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.description_login),
                fontSize = 14.sp,
                color = Color(160, 156, 156, 255),
            )

            Spacer(modifier = Modifier.height(64.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                OutlinedTextField(
                    value = "teste@email.com",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.email_label))) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(31.dp))

                OutlinedTextField(
                    value = "***************",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.password_label))) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(31.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240, 255))
                    ) {
                        Text(
                            text = stringResource(id = R.string.button_sing_in),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.arrow_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(31.dp))

                    Row() {
                        Text(
                            text = stringResource(id = R.string.text_dont_have_account),
                            fontSize = 12.sp,
                            color = Color(160, 156, 156, 255)
                        )

                        Text(
                            text = stringResource(id = R.string.text_sing_up),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = (Color(207, 6, 240, 255)
                                    ))
                    }
                }



            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {

            Surface(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(topEnd = 16.dp),
                color = Color(207, 6, 240, 255)
            ) {

            }
        }
    }
}