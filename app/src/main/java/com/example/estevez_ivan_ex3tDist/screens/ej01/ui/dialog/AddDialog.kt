package com.example.estevez_ivan_ex3tDist.screens.ej01.ui.dialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.estevez_ivan_ex3tDist.R

@Composable
fun AddDialog(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    confirmString: String = stringResource(R.string.ok),
    titleString: String = stringResource(R.string.usuario_registrado_correctamente),
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        buttons = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text(text = confirmString)
            }
        },
        modifier = modifier,
        title = { Text(text = titleString) },
    )
}