package com.example.tvshowapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tvshowapp.viewmodel.TvShowViewModel
import com.example.tvshowapp.model.data.TvShow
import com.example.tvshowapp.view.BottomNavBar
import com.example.tvshowapp.view.TopBar
import com.example.tvshowapp.view.TvShowGrid

@Composable
fun TvShowListScreen(viewModel: TvShowViewModel = viewModel()) {
    val tvShows by viewModel.tvShows.collectAsState()
    var selectedTab by remember { mutableStateOf("Home") }

    LaunchedEffect(Unit) {
        viewModel.loadTvShows()
    }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomNavBar(current = selectedTab, onItemClick = { selectedTab = it })
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (selectedTab) {
                "Home" -> TvShowGrid(tvShows)
                "Search" -> CenterText("Search Coming Soon")
                "Watchlist" -> CenterText("Your Watchlist is empty")
            }
        }
    }
}

@Composable
fun CenterText(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text)
    }
}

