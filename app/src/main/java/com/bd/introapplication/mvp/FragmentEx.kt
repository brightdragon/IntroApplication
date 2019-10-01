package com.bd.introapplication.mvp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.replaceFragmentActivity(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.actionTransact {
        replace(frameId, fragment)
    }
}

private inline fun FragmentManager.actionTransact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}