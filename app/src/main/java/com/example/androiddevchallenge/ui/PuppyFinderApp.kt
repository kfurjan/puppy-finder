package com.example.androiddevchallenge.ui

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.util.DATA_IMPORTED
import com.example.androiddevchallenge.util.getBooleanPreference
import com.example.androiddevchallenge.util.isOnline

@Composable
fun PuppyFinderApp() {
    val context = LocalContext.current
    var isOnline by remember { mutableStateOf(context.isOnline()) }

    when {
        isOnline -> Home()
        context.getBooleanPreference(DATA_IMPORTED) -> PuppyListViewer()
        else -> OfflineDialog { isOnline = context.isOnline() }
    }
}

@Composable
fun OfflineDialog(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(R.string.connection_error_title)) },
        text = { Text(text = stringResource(R.string.connection_error_message)) },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(stringResource(R.string.retry_label))
            }
        }
    )
}
