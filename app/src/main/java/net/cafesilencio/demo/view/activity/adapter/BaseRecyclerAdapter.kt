package net.cafesilencio.demo.view.adapter

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView


/**
 * Created by Seth Bourget on 2/11/18.
 */
abstract class BaseRecyclerAdapter<T, U : RecyclerView.ViewHolder>(private val hasSameIdFunc: (T, T) -> Boolean): RecyclerView.Adapter<U>() {

    protected val values: MutableList<T> = mutableListOf()
    private val clicksRelay: PublishRelay<Pair<Int, T>> = PublishRelay.create()
    private val longClicksRelay: PublishRelay<Pair<Int, T>> = PublishRelay.create()
    private var haveSameContentFunc: (T,T) -> Boolean = { itemA, itemB -> itemA == itemB ?: false }

    protected constructor(hasSameIdFunc: (T,T) -> Boolean, haveSameContentFunc: (T,T) -> Boolean): this(hasSameIdFunc) {
        this.haveSameContentFunc = haveSameContentFunc
    }

    override fun getItemCount(): Int = values.size

    fun swap(newValues: List<T>) {
        val diffResult = DiffUtil.calculateDiff(createElementsDiffCallback(newValues))
        values.clear()
        values.addAll(newValues)
        diffResult.dispatchUpdatesTo(this)
    }

    private fun createElementsDiffCallback(newValues: List<T>): DiffUtil.Callback {
        return object: DiffUtil.Callback() {
            override fun getOldListSize(): Int = values.size
            override fun getNewListSize(): Int = newValues.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = hasSameIdFunc(values[oldItemPosition], newValues[newItemPosition])
            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = haveSameContentFunc(values[oldItemPosition], newValues[newItemPosition])
        }
    }

    override fun onBindViewHolder(holder: U, position: Int) {
        val element: T = values[position]
        holder.itemView.setOnClickListener { clicksRelay.accept(Pair(position, element)) }
        holder.itemView.setOnLongClickListener {
            longClicksRelay.accept(Pair(position, element))
            true
        }
        onBindViewHolder(holder, position, element)
    }

    protected abstract fun onBindViewHolder(holder: U, position: Int, element: T)
    protected fun getPosition(position: Int): T = values[position]
    fun getCloneOfValues(): List<T> = values.toList()
    open fun getClicks(): Observable<Pair<Int, T>> = clicksRelay.hide()
    open fun getLongClicks(): Observable<Pair<Int, T>> = longClicksRelay.hide()
}