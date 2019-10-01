package com.bd.introapplication.mvp.ui

import com.bd.introapplication.R
import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.base.BaseFragment
import com.bd.introapplication.mvp.presenter.IntroContract
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroFragment : BaseFragment(), IntroContract.IntroView {

    private lateinit var listener: FragmentSelectedListener

    companion object {
        val TAG: String = IntroFragment::class.java.simpleName
        fun newInstance(): IntroFragment {
            return IntroFragment()
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_intro

    override fun initialize() {
        btn_intro.setOnClickListener {
            listener.setFragmentSelect(IntroViewType.VIEW_LOGIN)
        }
    }

    override fun setFragmentSelectListener(listener: FragmentSelectedListener) {
        this.listener = listener
    }

    override fun setPresenter(presenter: IntroContract.IntroPresenter) {

    }
}