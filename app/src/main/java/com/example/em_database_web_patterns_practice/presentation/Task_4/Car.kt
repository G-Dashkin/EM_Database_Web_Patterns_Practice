package com.example.em_database_web_patterns_practice.presentation.Task_4

class Car private constructor(builder: Car.Builder) {
    val brand: String
    val model: String
    val year: Int
    val color: String?
    val transmissionType: String?
    val engineCapacity: Double?

    init {
        brand = builder.brand
        model = builder.model
        year = builder.year
        color = builder.color
        transmissionType = builder.transmissionType
        engineCapacity = builder.engineCapacity
    }

    class Builder(val brand: String, val model: String, val year: Int) {
        var color: String? = null
            private set
        var transmissionType: String? = null
            private set
        var engineCapacity: Double? = null
            private set

        fun setColor(color: String) = apply { this.color = color }
        fun setTransmissionType(transmissionType: String) = apply { this.transmissionType = transmissionType }
        fun setEngineCapacity(engineCapacity: Double) = apply { this.engineCapacity = engineCapacity }

        fun build(): Car {
            // Optional validation can be added here
            return Car(this)
        }
    }
}