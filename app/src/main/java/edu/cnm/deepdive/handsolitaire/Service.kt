package edu.cnm.deepdive.handsolitaire

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import edu.cnm.deepdive.handsolitaire.model.Badge
import edu.cnm.deepdive.handsolitaire.model.Game
import edu.cnm.deepdive.handsolitaire.model.User
import edu.cnm.deepdive.handsolitaire.model.dao.BadgeDao
import edu.cnm.deepdive.handsolitaire.model.dao.GameDao
import edu.cnm.deepdive.handsolitaire.model.dao.UserDao
import java.time.Instant

class Converters {

    @TypeConverter
    fun fromInstant(value: Instant?): Long? = value?.toEpochMilli()

    fun toInstant(value: Long?): Instant? = value?.let { Instant.ofEpochMilli(it) }

}

@Database(
    entities = [User::class, Game::class, Badge::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class HandSolitaireDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getGameDao(): GameDao

    abstract fun getBadgeDao(): BadgeDao

    companion object {
        const val NAME = "hand_solitaire_db"
    }

}