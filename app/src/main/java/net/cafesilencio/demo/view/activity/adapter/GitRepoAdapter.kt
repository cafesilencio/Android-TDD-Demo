package net.cafesilencio.demo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import net.cafesilencio.demo.view.adapter.viewholder.GitRepoViewHolder
import net.cafesilencio.demo.R
import net.cafesilencio.demo.model.GitRepoRecord


/**
 * Created by Seth Bourget on 4/7/18.
 */
class GitRepoAdapter(hasSameIdFunc: (GitRepoRecord, GitRepoRecord) -> Boolean): BaseRecyclerAdapter<GitRepoRecord, GitRepoViewHolder>(hasSameIdFunc) {

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int, element: GitRepoRecord) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.git_repo_layout, parent, false)
        return GitRepoViewHolder(v)
    }

}