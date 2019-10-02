package com.bd.introapplication.mvp.data.source

import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import io.reactivex.Single
import io.reactivex.rxkotlin.toObservable

interface IntroDataSource {

//   fun getPermission(permission: Array<String>)

   fun isPermission(): Boolean
   fun isLogin(): Boolean
   fun getPermission(permissions: Array<String>): Single<List<String>>
   fun getPermissions(permissions: Array<String>): List<String>

}