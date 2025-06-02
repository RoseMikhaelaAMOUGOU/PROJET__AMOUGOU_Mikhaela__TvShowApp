package com.example.tvshowapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tvshowapp.viewmodel.TvShowViewModel
import com.example.tvshowapp.model.data.TvShow

@Composable
fun TvShowListScreen(
    navController: NavController,
    viewModel: TvShowViewModel = viewModel(),
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    val tvShows by viewModel.tvShows.collectAsState()
    var selectedTab by remember { mutableStateOf("Home") }

    LaunchedEffect(Unit) {
        viewModel.loadTvShows()
    }

    Scaffold(
        topBar = { TopBar(isDarkTheme = isDarkTheme, onToggleTheme = onToggleTheme) },
        bottomBar = {
            BottomNavBar(
                current = selectedTab,
                onItemClick = { selectedTab = it },
                isDarkTheme = isDarkTheme
            )
        },
        containerColor = if (isDarkTheme) Color(0xFF0F1115) else Color.White
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (selectedTab) {
                "Home" -> TvShowGrid(
                    tvShows = tvShows,
                    onClick = { selected: TvShow ->
                        navController.navigate("details/${selected.id}")
                    },
                    isDarkTheme = isDarkTheme
                )

                "Search" -> CenterText("Search Coming Soon", isDarkTheme)
                "Watchlist" -> CenterText("Your Watchlist is empty", isDarkTheme)
            }
        }
    }
}

@Composable
fun CenterText(text: String, isDarkTheme: Boolean) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isDarkTheme) Color.White else Color.Black
        )
    }
}




