
package dev.myhappyplace.multipreviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter

@Composable
fun App() {
    AppTheme {
        AppContent(Modifier.fillMaxSize())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Good Morning,",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            text = "My Dashboard",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 16.dp,
                bottom = 16.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(maxLineSpan) }) {
                FeaturedCard()
            }
            
            items(dashboardItems) { item ->
                DashboardCard(item)
            }
        }
    }
}

@Composable
fun FeaturedCard() {
    Card(
        modifier = Modifier.fillMaxWidth().height(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            Column(modifier = Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = "Welcome Back!",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "You have 3 new tasks today.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                )
            }
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopEnd).height(48.dp).aspectRatio(1f),
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
            )
        }
    }
}

@Composable
fun DashboardCard(item: DashboardItem) {
    Card(
        modifier = Modifier.aspectRatio(1f),
        colors = CardDefaults.cardColors(
            containerColor = item.color.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .aspectRatio(1f)
                    .background(item.color, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

data class DashboardItem(val title: String, val icon: ImageVector, val color: Color)

val dashboardItems = listOf(
    DashboardItem("Home", Icons.Default.Home, Color(0xFFFF6F00)),
    DashboardItem("Favorites", Icons.Default.Favorite, Color(0xFFD50000)),
    DashboardItem("Cart", Icons.Default.ShoppingCart, Color(0xFF2962FF)),
    DashboardItem("Search", Icons.Default.Search, Color(0xFF00C853)),
    DashboardItem("Settings", Icons.Default.Settings, Color(0xFF6200EE)),
    DashboardItem("Profile", Icons.Default.AccountCircle, Color(0xFFAA00FF)),
)

@Composable
@Preview
private fun AppPreview(
    @PreviewParameter(PreviewEnvironmentProvider::class) preview: PreviewEnvironment,
) {
    Multipreview(preview) {
        AppContent(Modifier.fillMaxSize())
    }
}
