package com.garyohosu.barcodereader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.garyohosu.barcodereader.ui.theme.BarcodeReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarcodeReaderTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    // TODO: Task 3 で画面遷移を実装する
                }
            }
        }
    }
}
