package com.rach.paginationproject.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dimensions(
    @SerialName("depth")
    val depth: Double = 0.0,
    @SerialName("height")
    val height: Double = 0.0,
    @SerialName("width")
    val width: Double = 0.0
)