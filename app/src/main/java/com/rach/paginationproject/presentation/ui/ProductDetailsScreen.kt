package com.rach.paginationproject.presentation.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.rach.paginationproject.AppPreview
import com.rach.paginationproject.data.model.Product
import com.rach.paginationproject.presentation.theme.PaginationProjectTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductDetailScreen(
    product: Product
) {

    val imageList = product.images
    val pagerState = rememberPagerState(pageCount = { imageList.size })
    Log.d("huma", product.images.size.toString())


    LaunchedEffect(pagerState) {
        while (true) {
            delay(1500)
            val nextPage = (pagerState.currentPage + 1) % imageList.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = true,
            ) { index ->

                SliderImage(
                    index = index,
                    images = imageList,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }

        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = product.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
            Text(
                text = "⭐ ${String.format("%.1f", product.rating)}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color(0xFFFFD700)
                )
            )
        }

        product.brand?.let {
            Text(
                text = it,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //Price
            Text(
                "$${String.format("%.2f", product.price)}",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 20.sp
                )
            )

            Text(
                text = "${String.format("%.1f", product.discountPercentage)}% OFF",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFFFF6200),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )


        }

        Spacer(modifier = Modifier.height(12.dp))
        // Description
        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        )
    }

}

@Composable
private fun SliderImage(
    modifier: Modifier = Modifier,
    index: Int, images: List<String>
) {

    val painterState = rememberAsyncImagePainter(model = images[index])

    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterState,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        )

        when (val state = painterState.state) {

            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center)
                )
            }

            is AsyncImagePainter.State.Error -> {
                Text(
                    text = "Failed to load image",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                null
            }

        }
    }

}


@AppPreview
@Composable
private fun Preview() {
    PaginationProjectTheme {
        //ProductDetailScreen()
    }
}