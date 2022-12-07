package com.wallyson.kotlinapitemplate

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FooBarRepository: CrudRepository<FooBar, Long> {
}