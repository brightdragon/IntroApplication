package com.bd.introapplication.mvp.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}