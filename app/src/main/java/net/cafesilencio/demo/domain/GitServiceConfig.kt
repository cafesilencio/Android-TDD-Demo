package net.cafesilencio.demo.domain

import javax.inject.Inject

/**
 * Created by Seth Bourget on 4/14/18.
 */
open class GitServiceConfig

    @Inject
    constructor() {

    open fun getGitRepoUrl(): String = "https://api.github.com/repositories"
}