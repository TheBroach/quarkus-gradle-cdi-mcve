package com.example.domain.ports.ingoing

import com.example.domain.ports.outgoing.DummyRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class DummyUseCase @Inject constructor(private val dummyRepository: DummyRepository) {
    fun handle() = dummyRepository.getCoolInfo()
}