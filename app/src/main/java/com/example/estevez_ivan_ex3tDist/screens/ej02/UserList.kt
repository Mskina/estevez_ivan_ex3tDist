package com.example.estevez_ivan_ex3tDist.screens.ej02

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.estevez_ivan_ex3tDist.screens.ej01.data.model.User

@Composable
fun UserList(
    list: List<User>,
    onCheckedItem: (User, Boolean) -> Unit,
    onCloseItem: (User) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { it.id })
        { element ->
            UserListItem(
                userName = element.name,
                userMail = element.email,
                userPwd = element.pwd,
                onClose = { onCloseItem(element) },
                checked = element.checked,
                onCheckedChange = { checked -> onCheckedItem(element, checked) },
            )
        }
    }
}
