package com.bd.introapplication.mvp.ui

import com.bd.introapplication.R
import com.bd.introapplication.mvp.base.BaseFragment
import com.bd.introapplication.mvp.presenter.IntroContract

class LoginFragment : BaseFragment(), IntroContract.LoginView {

    private lateinit var listener: FragmentSelectedListener

    companion object {
        val TAG: String = LoginFragment::class.java.simpleName
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_login

    override fun initialize() {

    }

    override fun setFragmentSelectListener(listener: FragmentSelectedListener) {
        this.listener = listener
    }

    override fun setPresenter(presenter: IntroContract.LoginPresenter) {
    }

}