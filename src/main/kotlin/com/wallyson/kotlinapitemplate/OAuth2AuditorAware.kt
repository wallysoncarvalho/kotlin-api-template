package com.wallyson.kotlinapitemplate

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.stereotype.Component
import java.util.*

class OAuth2AuditorAware : AuditorAware<String> {

    override fun getCurrentAuditor(): Optional<String> {
        val jwt = SecurityContextHolder.getContext().authentication as JwtAuthenticationToken
        return Optional.of(jwt.tokenAttributes["name"] as String)
    }
}
