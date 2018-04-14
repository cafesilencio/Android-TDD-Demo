package net.cafesilencio.demo.view.activity.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import net.cafesilencio.demo.domain.GetGitRepos
import javax.inject.Inject

/**
 * Created by Seth Bourget on 4/7/18.
 */
class MainActivityViewModelFactory

    @Inject
    constructor(private val getGitRepos: GetGitRepos): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(getGitRepos) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}