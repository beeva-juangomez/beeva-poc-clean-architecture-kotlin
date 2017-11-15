package com.github.cleanArchitectureKotlin.ui.recoverPassword.activity

import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import com.github.cleanArchitectureKotlin.R
import com.github.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword.RecoverPasswordActivityModule
import com.github.cleanArchitectureKotlin.ui.base.*
import com.github.cleanArchitectureKotlin.ui.recoverPassword.presenter.RecoverPasswordPresenter
import com.pnikosis.materialishprogress.ProgressWheel
import kotlinx.android.synthetic.main.activity_recover_password.*
import kotlinx.android.synthetic.main.progress_bar_default.*
import javax.inject.Inject


class RecoverPasswordActivity : BaseActivity(), RecoverPasswordView {

    @Inject
    lateinit var presenter: RecoverPasswordPresenter

    override var layoutId: Int = R.layout.activity_recover_password

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(RecoverPasswordActivityModule(this))
                .injectTo(this)
    }

    override fun showIncorrectEmailFormatError() {
        toast(getString(R.string.recover_password_error_email_format))
    }

    override fun showUserNotFoundError() {
        toast(getString(R.string.recover_password_error_user_not_found))
    }

    override fun showRecoverPasswordLoading() {
        progress_wheel.visible()
        button_recover_password.gone()
    }

    override fun hideRecoverPasswordLoading() {
        progress_wheel.gone()
        button_recover_password.visible()
    }

    @OnClick(R.id.button_recover_password)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.button_recover_password -> presenter.recoverPassword(input_email.text())
        }
    }
}