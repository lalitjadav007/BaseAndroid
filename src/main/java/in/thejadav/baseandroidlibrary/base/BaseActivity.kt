package `in`.thejadav.baseandroidlibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = this.getViewModelClass()
    }

    fun replaceFragment(id: Int, fragment: Fragment, tag: String = ""){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(id, fragment, tag)
        ft.commit()
    }

    abstract fun getViewModelClass() : VM
}