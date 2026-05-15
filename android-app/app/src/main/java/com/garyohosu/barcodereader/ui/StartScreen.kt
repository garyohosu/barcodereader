package com.garyohosu.barcodereader.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(
    permissionDenied: Boolean,
    onScanStart: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "バーコード照合",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )

        if (permissionDenied) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "カメラの使用が許可されていません。\n設定アプリからカメラ権限を有効にしてください。",
                color = Color(0xFFB00020),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onScanStart,
            enabled = !permissionDenied
        ) {
            Text(text = "スタート")
        }
    }
}
