package com.bd.introapplication.mvp.data.source

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.bd.introapplication.util.Pref
import io.reactivex.Single
import io.reactivex.rxkotlin.toObservable

class IntroRepository(
    private val context: Context
) : IntroDataSource {

    override fun getPermissions(permissions: Array<String>): List<String> {
        return permissions.filter {
            PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(context, it)
        }
    }

    override fun getPermission(permissions: Array<String>): Single<List<String>> {
        return permissions.toObservable()
            .filter {
                PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(context, it)
            }.toList()
    }

    override fun isLogin(): Boolean {
        return Pref.load(context, Pref.BOOLEAN_LOGIN_CHECK)
    }

    override fun isPermission(): Boolean {
        return true
    }
}