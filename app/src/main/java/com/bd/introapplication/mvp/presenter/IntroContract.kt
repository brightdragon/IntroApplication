package com.bd.introapplication.mvp.presenter

import com.bd.introapplication.mvp.base.BasePresenter
import com.bd.introapplication.mvp.base.BaseView
import com.bd.introapplication.mvp.ui.FragmentSelectedListener

interface IntroContract {

    interface IntroView: BaseView<IntroPresenter>{
        fun setFragmentSelectListener(listener: FragmentSelectedListener)
    }

    interface IntroPresenter: BasePresenter {

    }

    interface LoginView: BaseView<LoginPresenter>{
        fun setFragmentSelectListener(listener: FragmentSelectedListener)
    }

    interface LoginPresenter: BasePresenter {

    }

    interface PermissionView: BaseView<PermissionPresenter>{
        fun setFragmentSelectListener(listener: FragmentSelectedListener)
    }

    interface PermissionPresenter: BasePresenter {

    }

}