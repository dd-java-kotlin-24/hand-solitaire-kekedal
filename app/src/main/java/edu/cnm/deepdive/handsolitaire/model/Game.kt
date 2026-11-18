package edu.cnm.deepdive.handsolitaire.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(
    tableName = "game",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["user_id"])
    ]
)
data class Game(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "game_id")
    val id: Long = 0,

    @ColumnInfo(name = "user_id")
    val userId: Long,

    @ColumnInfo(name = "cards_remaining")
    val cardsRemaining: Int,

    @ColumnInfo(name = "finished")
    val finished: Boolean,

    @ColumnInfo(name = "started_at")
    val startedAt: Instant,

    @ColumnInfo(name = "duration")
    val duration: Long
)