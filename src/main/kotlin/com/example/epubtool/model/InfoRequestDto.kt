package com.example.epubtool.model

data class InfoRequestDto(
    val firstYear : Int,
    val lastYear : Int,
    val term : List<String>
)
