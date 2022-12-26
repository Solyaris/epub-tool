package com.example.epubtool.controllers

import com.example.epubtool.services.NewsService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/news")
@CrossOrigin(origins = ["*"], maxAge = 4800, allowCredentials = "false")
class NewsController(private val newsService: NewsService) {

    @GetMapping
    fun test() = newsService.test()

}