package com.example.jecpackcomposecatalogo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Esta es una Descripción muy guay :)") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")

                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")

                }
            }
        )
    }
}


@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Este es un Ejemplo")
                Text(text = "Este es un Ejemplo")
                Text(text = "Este es un Ejemplo")
            }
        }
    }

}
