package com.example.pr01.data.model

import android.util.Printer

data class User(
   override val id : Int? = null,
   override val firstName: String,
   override val lastName: String,
   override val maidenName: String,
   override val isDeleted: Boolean = false
) : Profile
