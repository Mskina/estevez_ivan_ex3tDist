package com.example.estevez_ivan_ex3tDist.screens.ej01.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.estevez_ivan_ex3tDist.R

@Composable
fun RegistroBlock(
    nameString: String,
    changeNameString: (String) -> Unit,
    emailString: String,
    changeEmailString: (String) -> Unit,
    pwdString: String,
    changePwdString: (String) -> Unit,
    pwdRepeatString: String,
    changePwdRepeatString: (String) -> Unit,
    validRepeatPwd: Boolean,
    nameError: Boolean,
    emailError: Boolean,
    enabledRegistro: Boolean,
    onSingin: () -> Unit,
) {

    OutlinedTextField(
        value = nameString,
        onValueChange = changeNameString,
        label = { Text(text = stringResource(R.string.nombre_de_usuario)) },
        isError = nameError,
    )

    OutlinedTextField(
        value = emailString,
        onValueChange = changeEmailString,
        label = { Text(text = stringResource(R.string.mail)) },
        isError = emailError,
    )

    OutlinedTextField(
        value = pwdString,
        onValueChange = changePwdString,
        label = { Text(text = stringResource(R.string.contrase_a)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        )

    OutlinedTextField(
        value = pwdRepeatString,
        onValueChange = changePwdRepeatString,
        label = { Text(text = stringResource(R.string.repetir_contrase_a)) },
        isError = validRepeatPwd,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )

    Button(
        onClick = onSingin,
        enabled = enabledRegistro
    ) {
        Text(text = stringResource(R.string.sign_in))
    }

}