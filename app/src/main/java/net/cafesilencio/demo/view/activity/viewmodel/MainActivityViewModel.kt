package net.cafesilencio.demo.view.activity.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import net.cafesilencio.demo.domain.GetGitRepos
import net.cafesilencio.demo.model.GitRepoRecord
import net.cafesilencio.demo.view.Response
import net.cafesilencio.demo.view.Status
import timber.log.Timber

/**
 * Created by Seth Bourget on 4/7/18.
 */
class MainActivityViewModel

    constructor(private val getGitRepos: GetGitRepos): ViewModel() {

    @JvmField
    protected val disposables = CompositeDisposable()

    val gitReposeLiveData: MutableLiveData<Response<List<GitRepoRecord>>> = MutableLiveData()



    fun loadRepos() {
//        disposables.add(getGitRepos.call()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnError {
//                    gitReposeLiveData.value = Response(Status.SUCCESS, null, it)
//                }
//                .doOnSuccess {
//                    gitReposeLiveData.value = Response(Status.SUCCESS, it, null)
//                }.subscribe())
    }

    override fun onCleared() {
        disposables.clear()
    }
}