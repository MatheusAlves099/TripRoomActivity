package br.senai.sp.jandira.activelogintriproom

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.activelogintriproom.components.BottomShape
import br.senai.sp.jandira.activelogintriproom.components.TopShape
import br.senai.sp.jandira.activelogintriproom.model.User
import br.senai.sp.jandira.activelogintriproom.repository.UserRepository
import br.senai.sp.jandira.activelogintriproom.ui.theme.ActiveLoginTripRoomTheme

class SingUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActiveLoginTripRoomTheme {
                SingUpScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SingUpScreen() {

    var userNameState by remember {
        mutableStateOf(value = "")
    }

    var phoneState by remember {
        mutableStateOf(value = "")
    }

    var emailState by remember {
        mutableStateOf(value = "")
    }

    var passwordState by remember {
        mutableStateOf(value = "")
    }

    var over18State by remember {
        mutableStateOf(value = false)
    }

    var context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Row(
            horizontalArrangement = Arrangement.End,
        ) {

            TopShape()
        }

        //----------------------------------->>>>>>>>>>>>>>
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.text_singUp),
                fontSize = 32.sp,
                color = Color(207, 6, 240, 255),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.text_create_account),
                fontSize = 14.sp,
                color = Color(160, 156, 156, 255),
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .size(100.dp)
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(alignment = Alignment.TopEnd),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.White
                            )
                        )
                    )
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .offset(x = 0.dp, y = 0.dp)
                        .align(alignment = Alignment.BottomEnd)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                OutlinedTextField(
                    value = userNameState,
                    onValueChange = { userNameState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.username_label))) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.username_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = emailState,
                    onValueChange = { emailState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.phone_label))) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.phone_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = phoneState,
                    onValueChange = { phoneState = it },
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

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = passwordState,
                    onValueChange = { passwordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.password_label))) },
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = over18State,
                        onCheckedChange = { over18State = it },
                        colors = CheckboxDefaults.colors(Color(207, 6, 240, 255)),

                        )
                    Text(
                        text = stringResource(id = R.string.text_checkbox),
                        fontSize = 14.sp
                    )
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            userSave(
                                context,
                                emailState,
                                userNameState,
                                phoneState,
                                passwordState,
                                over18State
                            )
                        },
                        Modifier
                            .height(48.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240, 255))
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_button_create),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .width(352.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_already),
                            fontSize = 12.sp,
                            color = Color(160, 156, 156, 255)
                        )

                        Text(
                            text = stringResource(id = R.string.text_singIn),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = (Color(207, 6, 240, 255)
                                    )
                        )
                    }
                }
            }
        }
        //-------------------------->>>>>>>>>>>>>>>>>>>>>>>>
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {

            BottomShape()
        }
    }
}

fun userSave(
    context: Context,
    email: String,
    userName: String,
    phone: String,
    password: String,
    isOver: Boolean
) {
    val userRepository = UserRepository(context)

    //Recuperando no banco um usuário que tenha o email informado
    var user = userRepository.findUserByEmail(email)

    //Se user for null, gravamos o novo usuário,
    //senão, avisamos que o usuário já existe.
    if (user == null) {
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(
            context,
            "User already exists!!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
