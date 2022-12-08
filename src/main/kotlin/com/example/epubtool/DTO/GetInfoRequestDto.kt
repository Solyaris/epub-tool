package com.example.epubtool.DTO

data class GetInfoRequestDto(
    val firstYear : Int,
    val lastYear : Int,
    val term : List<String>
)
