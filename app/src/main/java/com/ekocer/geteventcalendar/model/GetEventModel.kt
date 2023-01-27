package com.ekocer.geteventcalendar.model

data class GetEventModel(
    var id: Int = 0,
    var summary: String? = "",
    var startDate: String = "",
)
