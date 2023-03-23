package com.oguzdogdu.rickandmortycompose.navigation

sealed class Screens(val route:String){
    object Characters : Screens(route = "characters_screen")
}
