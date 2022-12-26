package com.example.epubtool.repository

import com.example.epubtool.model.News
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : CrudRepository<News, Long> {



}