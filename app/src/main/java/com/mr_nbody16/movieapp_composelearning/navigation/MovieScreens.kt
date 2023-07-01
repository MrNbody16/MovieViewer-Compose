package com.mr_nbody16.movieapp_composelearning.navigation


enum class MovieScreens {
    HomeScreen ,
    DetailsScreen;
    companion object {
        fun fromRoute(route : String?) : MovieScreens =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not a valid argument")
            }
    }
}