package com.example.domain.ports.outgoing

fun interface RemoteApiClient {
    suspend fun callApi()
}