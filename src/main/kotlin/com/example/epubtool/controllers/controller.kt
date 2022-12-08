package com.example.epubtool

import CorsFilter
import com.example.epubtool.DTO.GetInfoRequestDto
import com.example.epubtool.DTO.GetInfoResponseDto
import com.example.epubtool.services.InfoService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1")
@CrossOrigin(origins= arrayOf("*"), maxAge = 4800, allowCredentials = "false" )
class GenericEndpointV2 (
    val infoService: InfoService
        ){

    @PostMapping(value = arrayOf("/GetInfo"), consumes = arrayOf("application/json"))
    public fun getInfo(@RequestBody dto : GetInfoRequestDto) : ResponseEntity<Any>{
        return infoService.parseStats(dto.term, dto.firstYear, dto.lastYear)
    }

}
