package com.example.em_database_web_patterns_practice.presentation.Task_4

fun main() {
    val car = Car.Builder("Toyota", "Corolla", 2022)
        .setColor("Blue")
        .setTransmissionType("Automatic")
        .setEngineCapacity(1.8)
        .build()

    println("Brand: ${car.brand}, " +
            "Model: ${car.model}, " +
            "Year: ${car.year}, " +
            "Color: ${car.color}, " +
            "Transmission: ${car.transmissionType}, " +
            "Engine Capacity: ${car.engineCapacity}")
}