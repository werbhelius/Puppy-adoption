package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.MainDestinations.PUPPY_DETAIL_ID_KEY
import com.example.androiddevchallenge.ui.puppy.PuppyDetail
import com.example.androiddevchallenge.ui.puppys.PuppyList
import com.example.androiddevchallenge.ui.puppys.PuppyViewModel

/**
 * Created by wanbo on 2021/2/27.
 */

object MainDestinations {
    const val PUPPY_LIST = "puppys"
    const val PUPPY_DETAIL = "puppy"
    const val PUPPY_DETAIL_ID_KEY = "courseId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.PUPPY_LIST) {
    val navController = rememberNavController()
    val vm = PuppyViewModel()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.PUPPY_LIST) {
            PuppyList(actions.selectPuppy, vm)
        }
        composable(
            "${MainDestinations.PUPPY_DETAIL}/{$PUPPY_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_DETAIL_ID_KEY) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)

            PuppyDetail(
                puppyID = arguments.getString(PUPPY_DETAIL_ID_KEY)!!,
                upPress = actions.upPress,
                vm = vm)
        }
    }
}

class MainActions(navController: NavHostController) {
    val selectPuppy: (String) -> Unit = { puppyId: String ->
        navController.navigate("${MainDestinations.PUPPY_DETAIL}/$puppyId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}