package com.wisnu.kurniawan.debugview.internal.features.event.ui

import com.wisnu.kurniawan.debugview.internal.features.eventfilter.ui.FilterType
import com.wisnu.kurniawan.debugview.internal.foundation.extension.split
import com.wisnu.kurniawan.debugview.internal.foundation.wrapper.DateTimeProviderImpl
import com.wisnu.kurniawan.debugview.internal.model.Analytic
import com.wisnu.kurniawan.debugview.internal.model.Event

internal data class EventState(
    val analytic: Analytic,
    val events: List<Event>,
    val filterConfig: FilterConfig
) {

    val filterQuery = filterConfig.type.split(filterConfig.text)

    companion object {
        val initial = EventState(
            Analytic(
                id = "",
                tag = "",
                isRecording = false,
                createdAt = DateTimeProviderImpl().now()
            ),
            listOf(),
            FilterConfig("", FilterType.NEW_LINE)
        )
    }
}

internal data class FilterConfig(
    val text: String,
    val type: FilterType
)
