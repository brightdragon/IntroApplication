package com.bd.introapplication.mvp.ui

import com.bd.introapplication.R
import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.base.BaseFragment
import com.bd.introapplication.mvp.presenter.IntroContract
import com.bd.introapplication.util.Pref
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), IntroContract.IntroView {

    private lateinit var presenter: IntroContract.IntroPresenter
    private lateinit var listener: FragmentSelectedListener

    companion object {
        val TAG: String = LoginFragment::class.java.simpleName
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_login

    override fun initialize() {
        presenter.start()

        btn_login.setOnClickListener {
            Pref.save(context!!, Pref.BOOLEAN_LOGIN_CHECK, true)
            presenter.getIntroInfo()
        }
    }

    override fun setFragmentSelectListener(listener: FragmentSelectedListener) {
        this.listener = listener
    }

    override fun setPresenter(presenter: IntroContract.IntroPresenter) {
        this.presenter = checkNotNull(presenter)
    }

    override fun showNewFragmentTask(viewType: IntroViewType) {
        listener.setFragmentSelect(viewType)
    }

}