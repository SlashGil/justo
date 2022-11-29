package com.justo.android.justotechnicaltest.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.justo.android.justotechnicaltest.domain.entities.UserEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var user: String = ""
) {
    companion object {
        const val TABLE_NAME = "UserEntity"
    }
}
