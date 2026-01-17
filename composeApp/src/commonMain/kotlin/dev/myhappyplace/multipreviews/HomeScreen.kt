package dev.myhappyplace.multipreviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter


@Composable
fun HomeScreen() {
    AppTheme {
        Surface {
            HomeScreenContent()
        }
    }
}

@Composable
fun HomeScreenContent() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(modifier = Modifier.padding(50.dp), text = "Hello")
        }
    }
}

@Composable
@Preview
private fun HomeScreenPreview(
    @PreviewParameter(PreviewEnvironmentProvider::class) env: PreviewEnvironment
) {
    Multipreview(env) {
        HomeScreenContent()
    }
}
