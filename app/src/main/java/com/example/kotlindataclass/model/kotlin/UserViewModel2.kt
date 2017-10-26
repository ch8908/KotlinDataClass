package com.example.kotlindataclass.model.kotlin

import android.content.Context
import com.example.kotlindataclass.R

/**
 * Created by Kros on 26/10/2017.
 */
data class UserViewModel2 private constructor(
        val user: User,
        val ageString: String
) {
    companion object {
        fun create(context: Context, user: User): UserViewModel2 {
            val ageString = context.getString(R.string.age_is, user.age.toString())
            return UserViewModel2(user, ageString)
        }
    }
}