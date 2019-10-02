package com.bd.introapplication.util

import android.content.Context

class Pref {


    companion object {

        const val KEY_PREF = "IntroApp_Pref"
        const val BOOLEAN_LOGIN_CHECK = "boolean_login_check"

        fun <T> save(context: Context, key: String, t: T) {
            context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE).apply {
                when (key) {
                    BOOLEAN_LOGIN_CHECK -> edit().putBoolean(key, t as Boolean)
                    else -> edit().clear()
                }.commit()
            }
        }

        fun <T> load(context: Context, key: String): T {
            return context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE).apply {
                when (key) {
                    BOOLEAN_LOGIN_CHECK -> return getBoolean(key, false) as T
                }
            } as T
        }
    }
}