package com.example.epubtool

import com.example.epubtool.DTO.GetInfoRequestDto
import com.example.epubtool.DTO.GetInfoResponseDto
import com.example.epubtool.services.InfoService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1")

class GenericEndpointV2 (
    val infoService: InfoService
        ){

    @PostMapping("/GetInfo")
    public fun getInfo(@RequestBody dto : GetInfoRequestDto) : GetInfoResponseDto{
        return infoService.parseStats(dto.term, dto.firstYear, dto.lastYear)
    }

}
