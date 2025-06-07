package com.rach.paginationproject.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("availabilityStatus")
    val availabilityStatus: String = "",
    @SerialName("brand")
    val brand: String? = null,
    @SerialName("category")
    val category: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("dimensions")
    val dimensions: Dimensions = Dimensions(),
    @SerialName("discountPercentage")
    val discountPercentage: Double = 0.0,
    @SerialName("id")
    val id: Int = 0,
    @SerialName("images")
    val images: List<String> = listOf(),
    @SerialName("meta")
    val meta: Meta = Meta(),
    @SerialName("minimumOrderQuantity")
    val minimumOrderQuantity: Int = 0,
    @SerialName("price")
    val price: Double = 0.0,
    @SerialName("rating")
    val rating: Double = 0.0,
    @SerialName("returnPolicy")
    val returnPolicy: String = "",
    @SerialName("reviews")
    val reviews: List<Review> = listOf(),
    @SerialName("shippingInformation")
    val shippingInformation: String = "",
    @SerialName("sku")
    val sku: String = "",
    @SerialName("stock")
    val stock: Int = 0,
    @SerialName("tags")
    val tags: List<String> = listOf(),
    @SerialName("thumbnail")
    val thumbnail: String = "",
    @SerialName("title")
    val title: String = "",
    @SerialName("warrantyInformation")
    val warrantyInformation: String = "",
    @SerialName("weight")
    val weight: Int = 0
)