package com.api.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestfulApiKotlinApplication

fun main(args: Array<String>) {
	runApplication<RestfulApiKotlinApplication>(*args)
}
