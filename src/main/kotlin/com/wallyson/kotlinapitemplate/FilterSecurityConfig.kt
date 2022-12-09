package com.wallyson.kotlinapitemplate

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain
import org.springframework.stereotype.Component

@Component
class FilterSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors()
            .and()
            .authorizeRequests()
            .antMatchers("/private/**")
            .hasRole("ADMIN")
            .antMatchers("/public/**", "/actuator", "/actuator/*", "/doc/**").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt { jwt ->
                val converter = JwtAuthenticationConverter().apply {
                    setJwtGrantedAuthoritiesConverter(KeycloakRealmRoleConverter())
                }
                jwt.jwtAuthenticationConverter(converter)
            }

        return http.build()
    }
}
