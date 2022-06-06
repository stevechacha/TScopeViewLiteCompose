package com.steve.t_scopeviewlitecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.ramcosta.composedestinations.DestinationsNavHost
import com.steve.t_scopeviewlitecompose.ui.theme.TScopeViewLiteComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TScopeViewLiteComposeTheme {
                Scaffold() {
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}