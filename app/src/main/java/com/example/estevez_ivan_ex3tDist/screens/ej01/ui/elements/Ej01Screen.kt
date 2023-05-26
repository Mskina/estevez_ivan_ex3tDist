package com.example.estevez_ivan_ex3tDist.screens.ej01.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.estevez_ivan_ex3tDist.R
import com.example.estevez_ivan_ex3tDist.screens.ej01.ui.dialog.AddDialog
import com.example.estevez_ivan_ex3tDist.screens.ej01.ui.dialog.ErrDialog
import com.example.estevez_ivan_ex3tDist.screens.ej01.ui.state.ViewModel

@Preview
@Composable
fun Ej01Screen() {
    val vm: ViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.registro)) },
                actions = {
                    Text(text = stringResource(R.string.clientes) + vm.items.size)
                })
        },
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            RegistroBlock(
                nameString = vm.nameString,
                changeNameString = { vm.changeNameString(it) },
                emailString = vm.emailString,
                changeEmailString = { vm.changeEmailString(it) },
                pwdString = vm.pwdString,
                changePwdString = { vm.changePwdString(it) },
                pwdRepeatString = vm.pwdRepeatString,
                changePwdRepeatString = { vm.changePwdRepeatString(it) },
                validRepeatPwd = vm.diffPwd(),
                nameError = vm.nameError,
                emailError = vm.emailError,
                enabledRegistro = vm.validEmailAndPwd(),
                onSingin = { vm.singin() },
            )
        }

        if (vm.showAddDialog) {
            AddDialog(
                onDismiss = { vm.setAddDialog(false) }
            )
        } else if (vm.showErrDialog) {
            ErrDialog(
                onDismiss = { vm.setErrDialog(false) }
            )
        }
    }
}