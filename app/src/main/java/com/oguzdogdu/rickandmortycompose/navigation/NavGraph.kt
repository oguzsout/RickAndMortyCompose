package com.oguzdogdu.rickandmortycompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.oguzdogdu.rickandmortycompose.presentation.character.characterdetail.CharacterDetailScreen
import com.oguzdogdu.rickandmortycompose.presentation.character.characters.CharactersScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController(),paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screens.Characters.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable(route = Screens.Characters.route) {
            CharactersScreen(navigateToCharacterDetail = {
                navController.navigate("${Screens.CharacterDetail.route}/$it")
            })
        }

        composable(route = "${Screens.CharacterDetail.route}/{id}", arguments = listOf(navArgument("id"){
            type = NavType.IntType
        })) {
            CharacterDetailScreen()
        }
    }
}