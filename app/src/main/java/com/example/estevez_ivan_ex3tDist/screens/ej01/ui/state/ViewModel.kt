package com.example.estevez_ivan_ex3tDist.screens.ej01.ui.state

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.estevez_ivan_ex3tDist.screens.ej01.data.model.User

class ViewModel : ViewModel() {

    //private val _items = mutableStateListOf<User>()
    private val _items = getItems().toMutableStateList()
    val items: List<User>
        get() = _items

    fun remove(item: User) {
        _items.remove(item)
    }

    fun changeItemChecked(
        item: User,
        checked: Boolean
    ) =
        items.find { it.id == item.id }?.let { item ->
            item.checked = checked
        }

    // Nombre de usuario
    private var _nameString by mutableStateOf("")
    val nameString get() = _nameString

    fun changeNameString(it: String) {
        _nameString = it.trim()
        _nameError = false
    }

    // Correo electrónico
    private var _emailString by mutableStateOf("")
    val emailString get() = _emailString

    fun changeEmailString(it: String) {
        _emailString = it.trim()
        _emailError = false
    }

    // Contraseñas
    private var _pwdString by mutableStateOf("")
    val pwdString get() = _pwdString

    fun changePwdString(it: String) {
        _pwdString = it
    }

    private var _pwdRepeatString by mutableStateOf("")
    val pwdRepeatString get() = _pwdRepeatString

    fun changePwdRepeatString(it: String) {
        _pwdRepeatString = it
    }

    // Registro
    fun singin() {
        if (isUsernameFree() && isEmailFree() && !diffPwd()) {
            addUser(User(_nameString, _emailString, _pwdString))
            _nameString = ""
            _emailString = ""
            _pwdString = ""
            _pwdRepeatString = ""
            _showAddDialog = true
        }
        if (!isUsernameFree()) {
            _nameError = true
            _showErrDialog = true
        }
        if (!isEmailFree()) {
            _emailError = true
            _showErrDialog = true
        }
    }

    private fun addUser(item: User) =
        _items.add(item)

    // Errores
    private var _nameError by mutableStateOf(false)
    val nameError get() = _nameError

    private var _emailError by mutableStateOf(false)
    val emailError get() = _emailError

    /**
     * Devuelve true si el nombre no está en uso y false en caso contrario
     */
    fun isUsernameFree(): Boolean {
        return (items.none { nameString == it.name })
    }

    /**
     * Devuelve true si el mail no está en uso y false en caso contrario
     */
    fun isEmailFree(): Boolean {
        return (items.none { emailString == it.email })
    }

    /**
     * Devuelve true si el nombre tiene la longitud mínima, si el correo está bien escrito y
     * si las contraseñas coinciden. En caso contrario, devuelve false.
     */
    fun validEmailAndPwd(): Boolean {
        return _nameString.length > 3 &&
                Patterns.EMAIL_ADDRESS.matcher(_emailString).matches() &&
                _pwdString.length > 4 &&
                _pwdRepeatString.length > 4 && !diffPwd()
    }

    /**
     * Devuelve TRUE si las contraseñas no coinciden y FALSE en caso contrario
     */
    fun diffPwd(): Boolean {
        var valido = false
        if (_pwdRepeatString.isEmpty()) {
            valido = false
        }

        if (_pwdRepeatString.isNotEmpty() && _pwdString != _pwdRepeatString) {
            valido = true
        }
        return valido
    }

    // Diálogos de error y confirmación
    private var _showAddDialog by mutableStateOf(false)
    val showAddDialog get() = _showAddDialog

    fun setAddDialog(value: Boolean) {
        _showAddDialog = value
    }

    private var _showErrDialog by mutableStateOf(false)
    val showErrDialog get() = _showErrDialog

    fun setErrDialog(value: Boolean) {
        _showErrDialog = value
    }

}

// Generador de elementos iniciales
private fun getItems() = List(5) { i -> User("User $i", "mail$i@mail.com", "12345") }