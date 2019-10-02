package com.bd.introapplication.mvp

import androidx.fragment.app.Fragment
import com.bd.introapplication.R
import com.bd.introapplication.mvp.base.BaseActivity
import com.bd.introapplication.mvp.data.source.IntroRepository
import com.bd.introapplication.mvp.presenter.IntroContract
import com.bd.introapplication.mvp.presenter.IntroPresenter
import com.bd.introapplication.mvp.ui.FragmentSelectedListener
import com.bd.introapplication.mvp.ui.IntroFragment
import com.bd.introapplication.mvp.ui.LoginFragment
import com.bd.introapplication.mvp.ui.PermissionFragment

class IntroActivity : BaseActivity(), FragmentSelectedListener {

    private lateinit var mPresenter: IntroPresenter

    override fun getLayoutResource(): Int = R.layout.activity_main
    override fun initialize() {
        newFragmentTask(IntroViewType.VIEW_INTRO)
    }

    override fun setFragmentSelect(viewType: IntroViewType) {
        this@IntroActivity.newFragmentTask(viewType)
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)

        if (fragment is IntroFragment) {
            mPresenter = IntroPresenter(fragment, IntroRepository(this@IntroActivity))
            fragment.setFragmentSelectListener(this)
        } else if (fragment is PermissionFragment) {
            mPresenter = IntroPresenter(fragment, IntroRepository(this@IntroActivity))
            fragment.setFragmentSelectListener(this)
        } else if(fragment is LoginFragment){
            mPresenter = IntroPresenter(fragment, IntroRepository(this@IntroActivity))
            fragment.setFragmentSelectListener(this)
        }
    }

    private fun newFragmentTask(viewType: IntroViewType) =
        when (viewType) {
            IntroViewType.VIEW_INTRO -> {
                IntroFragment.newInstance().also {
                    replaceFragmentActivity(it, R.id.main_container, IntroFragment.TAG)
                }
            }

            IntroViewType.VIEW_LOGIN -> {
                LoginFragment.newInstance().also {
                    replaceFragmentActivity(it, R.id.main_container, LoginFragment.TAG)
                }
            }

            IntroViewType.VIEW_PERMISSION -> {
                PermissionFragment.newInstance().also {
                    replaceFragmentActivity(it, R.id.main_container, PermissionFragment.TAG)
                }
            }

            IntroViewType.VIEW_TERM -> {

            }

            IntroViewType.VIEW_OVERLAY -> {

            }
        }
}