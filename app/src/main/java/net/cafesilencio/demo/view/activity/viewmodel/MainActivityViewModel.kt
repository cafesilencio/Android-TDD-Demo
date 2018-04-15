package net.cafesilencio.demo.view.activity.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import net.cafesilencio.demo.domain.GetGitRepos
import net.cafesilencio.demo.domain.model.GitRepoRecord
import net.cafesilencio.demo.support.rxSingleDelegate
import net.cafesilencio.demo.view.Response
import net.cafesilencio.demo.view.Status

/**
 * Created by Seth Bourget on 4/7/18.
 */
class MainActivityViewModel

    constructor(private val getGitRepos: GetGitRepos): ViewModel() {

    @JvmField
    protected val disposables = CompositeDisposable()

    val gitReposeLiveData: MutableLiveData<Response<List<GitRepoRecord>>> = MutableLiveData()



    fun loadRepos() {
//        disposables.add(rxSingleDelegate(getGitRepos.call(),
//                                        getGitReposSuccess,
//                                        getGitReposeError,
//                                        getGitReposeResume))
    }

    val getGitReposSuccess = Consumer<List<GitRepoRecord>> { gitReposeLiveData.value = Response(Status.SUCCESS, it, null) }
    val getGitReposeError = Consumer<Throwable> { gitReposeLiveData.value = Response(Status.ERROR, null, it) }
    val getGitReposeResume = Function<Throwable, Single<List<GitRepoRecord>>> { Single.just(listOf()) }

    override fun onCleared() {
        disposables.clear()
    }
}