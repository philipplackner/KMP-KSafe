package com.plcoding.kmp_ksafe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = viewModel {
            SecureViewModel(createKSafe())
        }
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = viewModel::incrementCounter
                ) {
                    Text("Counter: ${viewModel.counter}")
                }

                Spacer(modifier = Modifier.height(64.dp))

                TextField(
                    value = viewModel.userProfile.email,
                    onValueChange = {
                        viewModel.updateProfile(
                            email = it,
                            password = viewModel.userProfile.password
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text("Email")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = viewModel.userProfile.password,
                    onValueChange = {
                        viewModel.updateProfile(
                            email = viewModel.userProfile.email,
                            password = it
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text("Password")
                    }
                )
            }
        }
    }
}