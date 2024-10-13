package com.store.movie.share.base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable


@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: List<T>?): Completable

    @Update
    fun update(entity: T): Completable

    @Update
    fun update(entities: List<T>?): Completable

    @Delete
    fun delete(entity: T): Completable

    @Delete
    fun delete(entities: List<T>?): Completable
}