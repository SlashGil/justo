package com.justo.android.justotechnicaltest.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.justo.android.justotechnicaltest.domain.entities.UserEntity
import com.justo.android.justotechnicaltest.domain.entities.UserEntity.Companion.TABLE_NAME

@Dao
interface UserDao {
    @Insert(entity = UserEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(UserEntity: UserEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllUsers(): LiveData<List<UserEntity>>

}