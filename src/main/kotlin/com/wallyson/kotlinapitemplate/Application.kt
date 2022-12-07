package com.wallyson.kotlinapitemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
class KotlinApiTemplateApplication

fun main(args: Array<String>) {
	runApplication<KotlinApiTemplateApplication>(*args)
}
