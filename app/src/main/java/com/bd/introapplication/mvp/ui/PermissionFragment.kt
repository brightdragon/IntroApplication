package com.bd.introapplication.mvp.ui

import android.util.Log
import androidx.core.app.ActivityCompat
import com.bd.introapplication.R
import com.bd.introapplication.mvp.IntroViewType
import com.bd.introapplication.mvp.base.BaseFragment
import com.bd.introapplication.mvp.data.PERMISSIONCODE
import com.bd.introapplication.mvp.data.listPermission
import com.bd.introapplication.mvp.data.source.IntroRepository
import com.bd.introapplication.mvp.presenter.IntroContract
import com.bd.introapplication.mvp.presenter.IntroPresenter
import kotlinx.android.synthetic.main.fragment_permission.*

class PermissionFragment : BaseFragment(), IntroContract.IntroView {

    private lateinit var presenter: IntroContract.IntroPresenter
    private lateinit var listener: FragmentSelectedListener

    companion object {
        val TAG: String = PermissionFragment::class.java.simpleName
        fun newInstance(): PermissionFragment {
            return PermissionFragment()
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_permission

    override fun initialize() {
        presenter.start()

        btn_permission.setOnClickListener {
            requestPermissions(listPermission, PERMISSIONCODE)
        }
    }

    override fun setPresenter(presenter: IntroContract.IntroPresenter) {
        this.presenter = checkNotNull(presenter)
    }

    override fun setFragmentSelectListener(listener: FragmentSelectedListener) {
        this.listener = listener
    }

    override fun showNewFragmentTask(viewType: IntroViewType) {
        listener.setFragmentSelect(viewType)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSIONCODE){
            presenter.getIntroInfo()
        }
    }

}