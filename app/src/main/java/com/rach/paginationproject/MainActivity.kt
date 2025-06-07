package com.rach.paginationproject

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rach.paginationproject.presentation.navigation.AppNav
import com.rach.paginationproject.presentation.theme.PaginationProjectTheme
import com.rach.paginationproject.presentation.viewModels.ProductViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PaginationProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNav(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
annotation class AppPreview
