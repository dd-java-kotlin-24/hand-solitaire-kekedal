package edu.cnm.deepdive.handsolitaire.model.entity

import android.R.attr.name
import android.companion.DeviceId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity
@ColumnInfo
@PrimaryKey(autoGenerate = true)
    val id: Long = 0L



@Entity(
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"]
    )]
)
