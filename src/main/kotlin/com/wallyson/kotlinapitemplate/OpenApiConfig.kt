package com.wallyson.kotlinapitemplate

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig(
    @Value("\${openidconnect.url}") private val tokenURL: String
) {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(info())
            .components(components())
            .security(listOf(SecurityRequirement().addList("openId")))
    }

    private fun info() = Info()
        .title("Kotlin API Template")
        .description("This is a template and sandbox application.")
        .termsOfService("terms")
        .contact(Contact().email("teste@teste.com").name("Developer: Old Father"))
        .license(License().name("GNU"))
        .version("2.0")

    private fun components() = Components().addSecuritySchemes(
        "openId", SecurityScheme()
            .type(SecurityScheme.Type.OPENIDCONNECT)
            .openIdConnectUrl(tokenURL)
    )
}
