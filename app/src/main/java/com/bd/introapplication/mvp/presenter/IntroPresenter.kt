package com.bd.introapplication.mvp.presenter

import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.data.listPermission
import com.bd.introapplication.mvp.data.source.IntroRepository

class IntroPresenter(
    private val view: IntroContract.IntroView,
    private val repository: IntroRepository
) : IntroContract.IntroPresenter {

    init {
        view.setPresenter(this)
    }

    override fun start() {
        view.setPresenter(this)
    }

    override fun getIntroInfo() {
        repository.getPermissions(listPermission).also {
            if (it.isNotEmpty()) {
                view.showNewFragmentTask(IntroViewType.VIEW_PERMISSION)
                return
            }
        }

        if (!repository.isLogin()) {
            view.showNewFragmentTask(IntroViewType.VIEW_LOGIN)
            return
        }
    }
}