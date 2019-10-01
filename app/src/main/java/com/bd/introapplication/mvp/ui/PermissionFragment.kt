package com.bd.introapplication.mvp.ui

import com.bd.introapplication.R
import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.base.BaseFragment
import com.bd.introapplication.mvp.presenter.IntroContract
import kotlinx.android.synthetic.main.fragment_permission.*

class PermissionFragment : BaseFragment(), IntroContract.PermissionView {

    private lateinit var listener: FragmentSelectedListener

    companion object{
        val TAG: String = PermissionFragment::class.java.simpleName
        fun newInstance(): PermissionFragment {
            return PermissionFragment()
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_permission

    override fun initialize() {
        btn_permission.setOnClickListener {
            listener.setFragmentSelect(IntroViewType.VIEW_INTRO)
        }
    }

    override fun setFragmentSelectListener(listener: FragmentSelectedListener) {
        this.listener = listener
    }

    override fun setPresenter(presenter: IntroContract.PermissionPresenter) {

    }

}