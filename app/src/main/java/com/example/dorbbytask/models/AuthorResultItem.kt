package com.example.dorbbytask.models

import java.io.Serializable

data class AuthorResultItem(
    val avatar: String,
    val createdAt: String,
    val descriptions: String,
    val id: String,
    val images: String,
    val name: String
):Serializable