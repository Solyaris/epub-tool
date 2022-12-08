package com.example.epubtool.services

import com.example.epubtool.DTO.GetInfoResponseDto
import org.springframework.stereotype.Service
import java.net.URL

@Service
class InfoService {

    private val BASE_URL = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&api_key=d1a08d6ec8192e868357af44a5d8fa0f2808"

    fun parseStats (terms : List<String>, firstYear: Int, lastYear: Int) : GetInfoResponseDto{
        val result : MutableMap <String, List<Int>> = mutableMapOf()
        for (term in terms) {
            val counts : MutableList<Int> = mutableListOf()
            for (currentYear in firstYear..lastYear) {
                val searchConditions = "&term=$term[Title]&mindate=$currentYear&maxdate=$currentYear&retmax=0&rettype[count]&retmode=json"
                val url = BASE_URL + searchConditions
                val value =  URL(url).readText().substring(71).substringBefore("\"").toInt()
                counts.add(value)
            }
            result.put(term, counts)
        }
        return GetInfoResponseDto(result)
    }
}


