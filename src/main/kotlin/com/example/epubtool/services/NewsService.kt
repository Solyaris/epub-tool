package com.example.epubtool.services

import com.example.epubtool.model.News
import com.example.epubtool.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(private val newsRepository: NewsRepository) {

    fun test() {
        newsRepository.save(News(id = 1, title = "Bomb", body = "A bomb"))
        println( newsRepository.findAll())
    }

}