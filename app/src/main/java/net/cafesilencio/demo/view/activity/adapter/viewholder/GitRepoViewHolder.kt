package net.cafesilencio.demo.view.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.git_repo_layout.view.*
import net.cafesilencio.demo.model.GitRepoRecord

/**
 * Created by Seth Bourget on 4/7/18.
 */
class GitRepoViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun setItem(item: GitRepoRecord) {
        itemView.repoName.text = item.name
        itemView.repoUrl.text = item.htmlUrl
    }
}