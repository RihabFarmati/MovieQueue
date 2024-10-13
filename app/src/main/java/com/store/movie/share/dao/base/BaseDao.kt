package com.store.movie.share.base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update


@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: List<T>?): List<Long?>?

    @Update
    fun update(entity: T): Int

    @Update
    fun update(entities: List<T>?): Int

    @Delete
    fun delete(entity: T): Int

    @Delete
    fun delete(entities: List<T>?): Int
}