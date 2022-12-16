package com.example.epubtool.controllers

import com.example.epubtool.DTO.InfoRequestDto
import com.example.epubtool.services.InfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = ["*"], maxAge = 4800, allowCredentials = "false")
class GenericEndpointV2(val infoService: InfoService) {

    @PostMapping(value = ["/Info"], consumes = ["application/json"])
    fun getInfo(@RequestBody dto: InfoRequestDto): ResponseEntity<Any> {
        return infoService.parseStats(dto.term, dto.firstYear, dto.lastYear)
    }

}
