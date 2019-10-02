package com.bd.introapplication.mvp.presenter

import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.base.BasePresenter
import com.bd.introapplication.mvp.base.BaseView
import com.bd.introapplication.mvp.ui.FragmentSelectedListener

interface IntroContract {

    interface IntroView : BaseView<IntroPresenter> {
        fun setFragmentSelectListener(listener: FragmentSelectedListener)
        fun showNewFragmentTask(viewType: IntroViewType)
    }

    interface IntroPresenter : BasePresenter {
        fun getIntroInfo()
    }
}