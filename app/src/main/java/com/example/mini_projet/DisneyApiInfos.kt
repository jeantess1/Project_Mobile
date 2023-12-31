package com.example.mini_projet


data class DisneyApiInfos(
    val count: Int,
    val totalPages: Int,
    val previousPage: String?,
    val nextPage: String?
)