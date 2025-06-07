package com.rach.paginationproject.data.network

import com.rach.paginationproject.data.model.Product
import com.rach.paginationproject.data.model.ProductResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

suspend fun fetchAllProducts():List<Product>{
    val response = KtorClientInstance.client.get("https://dummyjson.com/products")
        .body<ProductResponse>()

    return  response.products
}