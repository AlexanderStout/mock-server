package com.sasha.mockserver.controllers

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.*

@RestController
class MockServerController {

  @RequestMapping("/**")
  fun mockServer(@RequestBody body: String? = null, servletRequest: HttpServletRequest): ResponseEntity<String> {
    println("=============== ${LocalTime.now().truncatedTo(ChronoUnit.SECONDS)} REQUEST =========================")
    println("Request received at ${LocalTime.now().truncatedTo(ChronoUnit.SECONDS)}")

    println("Method: ${servletRequest.method}")
    println("Url: ${servletRequest.requestURL}")
    println()

    println("Headers:")

    // print all the headers
    val headerNames: Enumeration<*> = servletRequest.headerNames
    while (headerNames.hasMoreElements()) {
      val headerName = headerNames.nextElement() as String
       println("header: " + headerName + ": " + servletRequest.getHeader(headerName))
    }

    val queryString = servletRequest.queryString
    println()
    println("Query string: $queryString")

    println()
    println("Body:")
    println(body)

    println()
    println()

    return ResponseEntity.ok("mock server request received")
  }
}