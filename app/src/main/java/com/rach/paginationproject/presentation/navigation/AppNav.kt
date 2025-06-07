package com.rach.paginationproject.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rach.paginationproject.data.model.Product
import com.rach.paginationproject.presentation.ui.MainScreen
import com.rach.paginationproject.presentation.ui.ProductDetailScreen
import com.rach.paginationproject.presentation.viewModels.ProductViewModel
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder

enum class AppNavDest {
    MAIN_SCREEN, PRODUCT_DETAILS_SCREEN
}

@Composable
fun AppNav(modifier: Modifier = Modifier, viewModel: ProductViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNavDest.MAIN_SCREEN.toString()
    ) {
        composable(
            route = AppNavDest.MAIN_SCREEN.toString()
        ) {
            MainScreen(
                viewModel = viewModel,
                onProductClick = { product ->
                    val productJson = Json.encodeToString(product)
                    val encodedProduct = productJson.encodeURLPath()
                    navController.navigate("${AppNavDest.PRODUCT_DETAILS_SCREEN}/$encodedProduct")
                }
            )
        }

        composable(
            route = "${AppNavDest.PRODUCT_DETAILS_SCREEN}/{product}",
            arguments = listOf(
                navArgument("product") { type = NavType.StringType }
            )
        ) { navBackStackEntry ->
            val productJson = navBackStackEntry.arguments?.getString("product")?.decodeURLPath()
            val product = productJson?.let {
                Json.decodeFromString<Product>(it)
            }

            if (product != null) {
                ProductDetailScreen(product = product)
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Error loading product details",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

// Helper functions for URL encoding/decoding
fun String.encodeURLPath(): String = URLEncoder.encode(this, "UTF-8")
fun String.decodeURLPath(): String = URLDecoder.decode(this, "UTF-8")