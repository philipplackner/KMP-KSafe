package com.plcoding.kmp_ksafe

import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val email: String = "",
    val password: String = ""
)
