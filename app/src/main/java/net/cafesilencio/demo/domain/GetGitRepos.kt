package net.cafesilencio.demo.domain

import io.reactivex.Single
import net.cafesilencio.demo.domain.model.GitRepoRecord
import javax.inject.Inject
import net.cafesilencio.humblehttp.doGetCallForCollection
import net.cafesilencio.humblehttp.getHttpService
import net.cafesilencio.humblehttp.getObjectMapper

/**
 * Created by Seth Bourget on 4/14/18.
 */
open class GetGitRepos

    @Inject
    constructor(private val gitServiceConfig: GitServiceConfig) {

    open fun call(): Single<List<GitRepoRecord>> = Single.create { emitter ->
//        try {
//            val url = gitServiceConfig.getGitRepoUrl()
//            val items: List<GitRepoRecord> = doGetCallForCollection(url, ::getHttpService.invoke(), ::getObjectMapper.invoke())
//            emitter.onSuccess(items)
//        } catch(ex: Exception) {
//            emitter.onError(ex)
//        }
    }
}