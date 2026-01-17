package dev.myhappyplace.multipreviews

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    tertiary = Color(0xFF3700B3)
)

internal val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    tertiary = Color(0xFF03DAC6)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorScheme: ColorScheme? = null,
    content: @Composable () -> Unit
) {
    val finalColorScheme = colorScheme
        ?: if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = finalColorScheme,
        content = content
    )
}
