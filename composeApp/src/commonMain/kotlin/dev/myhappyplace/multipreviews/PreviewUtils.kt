package dev.myhappyplace.multipreviews

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

data class PreviewEnvironment(
    val name: String,
    val colorScheme: ColorScheme,
    val screenSize: DpSize,
    val fontScale: Float = 1.0f
)

class PreviewEnvironmentProvider : PreviewParameterProvider<PreviewEnvironment> {
    override val values = sequenceOf(
        // 1. Standard Phone (Light)
        PreviewEnvironment("Phone Light", LightColorScheme, DpSize(360.dp, 640.dp)),

        // 2. Standard Phone (Dark) - Mimics @PreviewLightDark
        PreviewEnvironment("Phone Dark", DarkColorScheme, DpSize(360.dp, 640.dp)),

        // 3. Tablet - Mimics @PreviewScreenSizes
        PreviewEnvironment("Tablet Light", LightColorScheme, DpSize(800.dp, 1280.dp)),

        // 4. Accessibility Check - Mimics @PreviewFontScale
        PreviewEnvironment("Big Font Dark", DarkColorScheme, DpSize(360.dp, 640.dp), fontScale = 1.5f)
    )
}

@Composable
fun Multipreview(
    env: PreviewEnvironment,
    modifier: Modifier = Modifier,
    wrapContent: Boolean = false,
    content: @Composable () -> Unit
) {
    val currentDensity = LocalDensity.current
    val customDensity = remember(currentDensity, env.fontScale) {
        Density(currentDensity.density, env.fontScale * currentDensity.fontScale)
    }

    CompositionLocalProvider(LocalDensity provides customDensity) {
        AppTheme(colorScheme = env.colorScheme) {
            Surface(
                modifier = if (wrapContent) modifier else modifier.size(env.screenSize),
                color = MaterialTheme.colorScheme.background
            ) {
                content()
            }
        }
    }
}
