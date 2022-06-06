package com.steve.t_scopeviewlitecompose.presentation.loginscreen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.steve.t_scopeviewlitecompose.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Destination(start = true)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val emailState = viewModel.userNameState.value
    val passwordState = viewModel.passwordState.value
    val loginState = viewModel.loginState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.SnackbarEvent -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
                is UiEvent.Navigate -> {
                    navController.navigate(event.route)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 50.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Sign In",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredUsername(it))
                },
                label = { Text(text = "Enter you name") },
                placeholder = { Text(text = "John Doe") },
            )


            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredPassword(it))
                },
                label = { Text(text = "Enter you password") },
                placeholder = { Text(text = "password") },
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    viewModel.onEvent(LoginEvent.Login)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(10.dp)
                )
            }

            if (loginState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            }
        }
    }
}