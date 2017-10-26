package com.example.kotlindataclass.model.kotlin

import com.google.gson.annotations.SerializedName
import io.mironov.smuggler.AutoParcelable
import java.util.*

/**
 * Created by Kros on 24/10/2017.
 */
data class User(
        @SerializedName("name") val name: String = "No Name",
        @SerializedName("email") val email: String? = null,
        @SerializedName("age") val age: Int = 0,
        @SerializedName("created_at") val createdAt: Date = Date()
) : AutoParcelable {
    fun updateAge(newAge: Int): User {
        name.toUpperCase()
        User()
        return copy(age = newAge)
    }
}
