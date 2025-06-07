package com.rach.paginationproject.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rach.paginationproject.theme.PaginationProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(modifier: Modifier = Modifier) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                "shop",
                modifier = Modifier.padding(start = 15.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu icon"
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search"
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More"
            )
        },
        scrollBehavior = scrollBehavior
    )

}

@Preview
@Composable
private fun Preview() {
    PaginationProjectTheme {
        CustomTopAppBar(
            modifier = Modifier.fillMaxWidth()
        )
    }
}