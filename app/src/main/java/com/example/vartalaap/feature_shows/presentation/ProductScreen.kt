package com.example.vartalaap.feature_shows.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ProductScreen(viewModel: ProductViewModel) {
    val context = LocalContext.current

    val state by viewModel.state.collectAsState()
    val (data, error, loading) = state.singleProduct

    if (error != null) {
        Toast.makeText(context, "${error.message} reason:${error.errorBody?.message}", Toast.LENGTH_SHORT).show()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (loading) {
            Text(text = "loading...")
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
                Text(text = "title: ${data?.title}")
                Text(text = "desc: ${data?.description}")
                Text(text = "price: ${data?.price}")
            }
        }
    }
}