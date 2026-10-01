package com.example.pr01.data.model

data class AuthorizedUser(
    override val id : Int? = null,
    override val firstName: String,
    override val lastName: String,
    override val maidenName: String,
    override val isDeleted: Boolean,
    val accessToken: String? = null
) : Profile
