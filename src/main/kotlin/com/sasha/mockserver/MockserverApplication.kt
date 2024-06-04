package com.sasha.mockserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockserverApplication

fun main(args: Array<String>) {
  runApplication<MockserverApplication>(*args)
}
