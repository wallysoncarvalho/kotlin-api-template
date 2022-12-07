package com.wallyson.kotlinapitemplate

import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.security.core.AuthenticatedPrincipal
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import kotlin.reflect.typeOf

@RestController
@RequestMapping("/private")
class PrivateResource(
    private val fooBarRepository: FooBarRepository
) {

    @GetMapping("/message")
    fun get1(jwtAuthToken: JwtAuthenticationToken) : String {
        val foobar = FooBar(name = "asdasda", age = 89)

        fooBarRepository.save(foobar)


        return "Private message for client '${jwtAuthToken.name}'"
    }
}