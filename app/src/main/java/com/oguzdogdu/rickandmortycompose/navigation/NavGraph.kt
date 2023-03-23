package com.oguzdogdu.rickandmortycompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oguzdogdu.rickandmortycompose.presentation.characters.CharactersScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController(),paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screens.Characters.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable(route = Screens.Characters.route) {
            CharactersScreen()
        }
    }
}