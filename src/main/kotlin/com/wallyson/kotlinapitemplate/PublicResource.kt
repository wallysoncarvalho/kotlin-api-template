package com.wallyson.kotlinapitemplate

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public")
class PublicResource {

    @GetMapping("/message")
    fun get1() : String = "public message"
}