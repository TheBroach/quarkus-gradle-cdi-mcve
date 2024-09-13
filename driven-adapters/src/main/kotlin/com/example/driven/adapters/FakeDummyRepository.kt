package com.example.driven.adapters

import com.example.domain.ports.outgoing.DummyRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class FakeisDummyRepository: DummyRepository {
    override fun getCoolInfo(): String = "Exactly what you were looking for."
}