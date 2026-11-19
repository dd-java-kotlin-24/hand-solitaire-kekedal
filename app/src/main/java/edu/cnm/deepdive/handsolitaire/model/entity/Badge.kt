package edu.cnm.deepdive.handsolitaire.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlin.time.Instant


@Entity(
    tableName = "badge",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Game::class,
            parentColumns = ["game_id"],
            childColumns = ["game_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index(value = ["user_id"]),
        Index(value = ["game_id"])
    ]
)
data class Badge(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "badge_id")
    val id: Long = 0,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "badge_type")
    val badgeType: String, // Or an enum (BadgeType) if preferred

    @ColumnInfo(name = "earned_at")
    val earnedAt: Instant,

    @ColumnInfo(name = "source")
    val source: String,

    @ColumnInfo(name = "spent_at")
    val spentAt: Instant? = null,

    @ColumnInfo(name = "game_id")
    val gameId: Long? = null
)