package com.bd.introapplication.mvp.base

import com.bd.introapplication.mvp.ui.FragmentSelectedListener

interface BaseView<T> {
    fun setPresenter(presenter: T)
}