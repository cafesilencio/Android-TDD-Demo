package net.cafesilencio.demo.view.activity.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import net.cafesilencio.demo.model.GitRepoRecord
import net.cafesilencio.demo.view.Response
import net.cafesilencio.demo.view.Status

/**
 * Created by Seth Bourget on 4/7/18.
 */
class MainActivityViewModel

    constructor(): ViewModel() {

    //val gitReposeLiveData: MutableLiveData<Response<List<GitRepoRecord>>> = MutableLiveData()

//    fun loadRepos() {
//        val gr1 = GitRepoRecord()
//        gr1.name = "repo ABC"
//        gr1.htmlUrl = "repo ABC url"
//
//        val gr2 = GitRepoRecord()
//        gr2.name = "repo LMNOP"
//        gr2.htmlUrl= "repo LMNOP url"
//
//        val gr3 = GitRepoRecord()
//        gr3.name = "repo XYZ"
//        gr3.htmlUrl = "repo XYZ url"
//
//        val repos = mutableListOf(gr1, gr2, gr3)
//        gitReposeLiveData.value = Response(Status.SUCCESS, repos, null)
//    }
}