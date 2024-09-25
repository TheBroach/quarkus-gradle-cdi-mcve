package com.example.driven.adapters

import com.example.domain.ports.outgoing.RemoteApiClient
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class FakeRemoteApiClient : RemoteApiClient {
    override suspend fun callApi() {
        TODO("Not yet implemented")
    }
}