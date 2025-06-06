package com.example.tvshowapp.view

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tvshowapp.viewmodel.TvShowViewModel

@Composable
fun TvShowAppNav(viewModel: TvShowViewModel) {
    val navController: NavHostController = rememberNavController()

    // 👇 Permet de mémoriser l'état du thème à travers les écrans
    var isDarkTheme by rememberSaveable { mutableStateOf(true) }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            TvShowListScreen(
                navController = navController,
                viewModel = viewModel,
                isDarkTheme = isDarkTheme,
                onToggleTheme = { isDarkTheme = !isDarkTheme }
            )
        }
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val tvShow = viewModel.tvShows.value.find { it.id == id }
            if (tvShow != null) {
                TvShowDetailScreen(
                    tvShow = tvShow,
                    onBack = { navController.popBackStack() },
                    isDarkTheme = isDarkTheme
                )
            }
        }
    }
}






