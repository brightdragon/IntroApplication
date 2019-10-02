package com.bd.introapplication.mvp.ui

import android.util.Log
import com.bd.introapplication.R
import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.base.BaseFragment
import com.bd.introapplication.mvp.data.source.IntroRepository
import com.bd.introapplication.mvp.presenter.IntroContract
import com.bd.introapplication.mvp.presenter.IntroPresenter
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroFragment : BaseFragment(), IntroContract.IntroView {

    private lateinit var presenter: IntroContract.IntroPresenter
    private lateinit var listener: FragmentSelectedListener

    companion object {
        val TAG: String = IntroFragment::class.java.simpleName
        fun newInstance(): IntroFragment {
            return IntroFragment()
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_intro

    override fun initialize() {
        presenter.start()
        presenter.getIntroInfo()

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

    override fun onDetach() {
        super.onDetach()
    }
}