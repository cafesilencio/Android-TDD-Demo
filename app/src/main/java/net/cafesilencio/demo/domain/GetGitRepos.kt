package net.cafesilencio.demo.domain

import io.reactivex.Single
import net.cafesilencio.demo.domain.model.GitRepoRecord
import javax.inject.Inject

/**
 * Created by Seth Bourget on 4/14/18.
 */
open class GetGitRepos

    @Inject
    constructor() {

    open fun call(): Single<List<GitRepoRecord>> = Single.create { emitter ->

    }
}