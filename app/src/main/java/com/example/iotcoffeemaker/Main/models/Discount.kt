package com.example.iotcoffeemaker.Main.models

import java.sql.Time

class Discount (
    val name: String,
    val value: String,
    val limit_time: Time,
    val company_name: String,
    val is_used: Boolean = false
)