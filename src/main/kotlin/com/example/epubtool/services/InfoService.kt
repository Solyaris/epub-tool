package com.example.epubtool.services

import com.example.epubtool.model.InfoResponseDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URL

@Service
class InfoService() {

    private val BASE_URL = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&api_key=d1a08d6ec8192e868357af44a5d8fa0f2808"

    fun parseStats (terms : List<String>, firstYear: Int, lastYear: Int) : ResponseEntity<Any> {
        val result: MutableMap<String, List<Int>> = mutableMapOf()
        terms.parallelStream().forEach {
            val counts: MutableList<Int> = mutableListOf()
            for (currentYear in firstYear..lastYear) {
                val searchConditions =
                    "&term=$it[Title]&mindate=$currentYear&maxdate=$currentYear&retmax=0&rettype[count]&retmode=json"
                val url = BASE_URL + searchConditions
                val value = URL(url).readText().substring(71).substringBefore("\"").toInt()
                counts.add(value)
            }
            result[it] = counts
        }

        val headers = HttpHeaders()
        headers.add(HttpHeaders.VARY, "Origin")
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PATCH, PUT, DELETE, OPTIONS")
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Origin, Content-Type, X-Auth-Token")
        headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "86400")
        return ResponseEntity(InfoResponseDto(result), HttpStatus.OK)
    }
}


