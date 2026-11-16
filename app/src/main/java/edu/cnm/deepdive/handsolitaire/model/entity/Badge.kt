package edu.cnm.deepdive.handsolitaire.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "badge",
    indices = [
        Index(value = ["badge_id"], unique = true)
    ]
)

data class Badge(
    @ColumnInfo(name = "badge_id")
    @PrimaryKey(autoGenerate = true)
    val badgeId: Long,
    val name: String,
    val description: String,
    val image: // TODO: find a image set for badges.

    @ForeignKey(
        entity = Badge::class,
        parentColumns = ["badge_id"],
        childColumns = ["badge_id"],
        onDelete = ForeignKey.CASCADE),


)
