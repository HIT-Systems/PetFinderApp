package com.example.myapplication.models

data class Pagination(
    val countPerPage: Int,
    val totalCount: Int,
    val currentPage: Int,
    val totalPages: Int,
)