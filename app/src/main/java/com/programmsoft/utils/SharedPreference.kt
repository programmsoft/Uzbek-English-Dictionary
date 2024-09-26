package com.programmsoft.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {
    private const val NAME = "ContentSharedPreference"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreference: SharedPreferences
    fun init(context: Context) {
        sharedPreference = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }
    var isAppFirstOpen: Int?
        get() = sharedPreference.getInt("isAppFirstOpen", 0)
        set(value) = sharedPreference.edit {
            it.putInt("isAppFirstOpen", value!!)
        }

    var isAllowNotification: Boolean
        get() = sharedPreference.getBoolean("isAllowNotification", false)
        set(value) = sharedPreference.edit {
            it.putBoolean("isAllowNotification", value)
        }

    var lastContentId: Long
        get() = sharedPreference.getLong("lastContentId", 1)
        set(value) = sharedPreference.edit {
            it.putLong("lastContentId", value)
        }
}