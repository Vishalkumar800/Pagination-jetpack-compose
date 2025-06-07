package com.rach.paginationproject.pagination

import com.rach.paginationproject.KtorClientInstance
import com.rach.paginationproject.model.Product
import com.rach.paginationproject.model.ProductResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

suspend fun fetchAllProducts():List<Product>{
    val response = KtorClientInstance.client.get("https://dummyjson.com/products")
        .body<ProductResponse>()

    return  response.products
}