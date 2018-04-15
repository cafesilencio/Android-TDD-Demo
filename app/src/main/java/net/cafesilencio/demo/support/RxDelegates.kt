package net.cafesilencio.demo.support

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by Seth Bourget on 4/14/18.
 */
inline fun <T> rxSingleDelegate(single: Single<T>,
                                successFunc: Consumer<T>,
                                errorFunc: Consumer<Throwable>,
                                resumeFunc: Function<Throwable, Single<T>>): Disposable = single
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnError(errorFunc)
        .onErrorResumeNext(resumeFunc)
        .doOnSuccess(successFunc)
        .subscribe()
