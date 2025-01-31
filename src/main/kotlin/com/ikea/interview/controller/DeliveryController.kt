package com.ikea.interview.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/deliveries")
class DeliveryController {
    @GetMapping
    fun getDeliveries(): ResponseEntity<String> {
        return ResponseEntity.ok("Deliveries to return here.")
    }

    @PostMapping
    fun createDummyDeliveries(): ResponseEntity<String> {
        // TODO you can use the given "sampleDeliveries.json" under resources to request to create a sample dataset for yourself.
        return ResponseEntity.ok("Success")
    }
}
