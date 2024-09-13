package com.example.driving.adapters

import com.example.domain.ports.ingoing.DummyUseCase
import io.github.oshai.kotlinlogging.KotlinLogging
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import jakarta.inject.Inject

@ApplicationScoped
class FakeDrivingAdapter @Inject constructor(private val dummyUseCase: DummyUseCase) {
    private val log = KotlinLogging.logger {  }

    fun startDrivingAdapter(@Observes startupEvent: StartupEvent) {
        log.info { "Starting Driving Adapter..." }
        dummyUseCase.handle().let { log.info { "Got this info from the use case: $it" } }
    }
}