package com.example.estevez_ivan_ex3tDist.screens.ej02

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.estevez_ivan_ex3tDist.R

@Composable
fun UserListItem(
    userName: String,
    userMail: String,
    userPwd: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {

    var showPwd by rememberSaveable { mutableStateOf(false) }
    var noPwd by rememberSaveable { mutableStateOf("*******") }
    val onClick = { showPwd = !showPwd }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 3.dp,
    ) {
        Column() {
            Row(
                modifier
                    .background(MaterialTheme.colors.secondary)
                    .clickable(onClick = onClick),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = userName,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(start = 16.dp),
                    )
                    Text(
                        text = userMail,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }

                Checkbox(
                    checked = checked,
                    onCheckedChange = onCheckedChange
                )

                IconButton(onClick = onClose) {
                    Icon(
                        Icons.Filled.Close,
                        tint = Color.White,
                        contentDescription = stringResource(R.string.cerrar)
                    )
                }
            }
            if (showPwd) {
                Row() {
                    TextField(
                        value = noPwd,
                        onValueChange = {},
                        readOnly = true,
                    )
                    IconButton(
                        onClick = { noPwd = userPwd }
                    ) {
                        Icon(Icons.Filled.Info, stringResource(R.string.mostrar_contrase_a))
                    }
                }
            }

        }
    }
}