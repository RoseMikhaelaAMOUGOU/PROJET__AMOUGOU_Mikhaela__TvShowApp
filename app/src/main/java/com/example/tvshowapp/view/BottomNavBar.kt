package com.example.tvshowapp.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val label: String, val icon: ImageVector) {
    object Home : BottomNavItem("Home", Icons.Filled.Home)
    object Search : BottomNavItem("Search", Icons.Filled.Search)
    object Watchlist : BottomNavItem("Watchlist", Icons.Filled.PlaylistAdd)
}

@Composable
fun BottomNavBar(current: String, onItemClick: (String) -> Unit, isDarkTheme: Boolean) {
    val items = listOf(BottomNavItem.Home, BottomNavItem.Search, BottomNavItem.Watchlist)

    NavigationBar(
        containerColor = if (isDarkTheme) Color(0xFF0F1115) else Color.White,
        contentColor = if (isDarkTheme) Color.White else Color.Black
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = current == item.label,
                onClick = { onItemClick(item.label) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (isDarkTheme) Color.White else Color.Black
                    )
                },
                label = {
                    Text(item.label, color = if (isDarkTheme) Color.White else Color.Black)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = if (isDarkTheme) Color(0xFF1C1E24) else Color(0xFFE0E0E0)
                )
            )
        }
    }
}

