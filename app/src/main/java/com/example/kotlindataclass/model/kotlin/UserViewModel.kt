package com.example.kotlindataclass.model.kotlin

import android.content.Context
import com.example.kotlindataclass.R

/**
 * Created by Kros on 26/10/2017.
 */
class UserViewModel(
        context: Context,
        val user: User
) {
    val context2 = context
    fun copy(context: Context, user: User): UserViewModel {
        return UserViewModel(context, user)
    }

    val ageString: String

    init {
        ageString = context.getString(R.string.age_is, user.age.toString())
    }
}