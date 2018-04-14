package net.cafesilencio.demo.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import net.cafesilencio.demo.R
import net.cafesilencio.demo.model.GitRepoRecord
import net.cafesilencio.demo.view.Response
import net.cafesilencio.demo.view.Status
import net.cafesilencio.demo.view.activity.viewmodel.MainActivityViewModel
import net.cafesilencio.demo.view.activity.viewmodel.MainActivityViewModelFactory
import net.cafesilencio.demo.view.adapter.GitRepoAdapter
import javax.inject.Inject

/**
 * Created by Seth Bourget on 4/14/18.
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainActivityViewModelFactory
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        val gitRepoAdapter = GitRepoAdapter({ a, b -> a.id == b.id })
        gitRepoList.layoutManager = LinearLayoutManager(this)
        gitRepoList.adapter = gitRepoAdapter

        observeReposLoaded()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadRepos()
    }

    fun observeReposLoaded() {
        viewModel.gitReposeLiveData.observe(this, Observer<Response<List<GitRepoRecord>>> { resp -> updateViewWithGitRecords(resp!!) })
    }

    fun updateViewWithGitRecords(resp: Response<List<GitRepoRecord>>) {
        val adapter = gitRepoList.adapter as GitRepoAdapter
        when(resp.status) {
            Status.SUCCESS -> {
                adapter.swap(resp.data ?: listOf())
            }
            Status.ERROR -> {
                //todo notify user
                adapter.swap(listOf())
            }
        }
    }
}