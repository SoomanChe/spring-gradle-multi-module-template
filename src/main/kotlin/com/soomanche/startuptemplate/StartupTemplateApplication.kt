package com.soomanche.startuptemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StartupTemplateApplication

fun main(args: Array<String>) {
    runApplication<StartupTemplateApplication>(*args)
}
