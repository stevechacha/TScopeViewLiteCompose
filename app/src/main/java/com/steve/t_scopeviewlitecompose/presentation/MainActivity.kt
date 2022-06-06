package com.steve.t_scopeviewlitecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.steve.t_scopeviewlitecompose.ui.theme.TScopeViewLiteComposeTheme
import com.steve.t_scopeviewlitecompose.ui.theme.darkGreen
import com.steve.t_scopeviewlitecompose.windowInfo.WindowInfo
import com.steve.t_scopeviewlitecompose.windowInfo.rememberWindowInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TScopeViewLiteComposeTheme {

                // A surface container using the 'background' color from the theme
                val windowInfo = rememberWindowInfo()
                if(windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {

                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                    }
                }
            }
        }
    }
}