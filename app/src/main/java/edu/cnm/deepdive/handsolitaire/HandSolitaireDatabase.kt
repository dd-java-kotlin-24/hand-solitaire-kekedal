package edu.cnm.deepdive.handsolitaire.service

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import edu.cnm.deepdive.handsolitaire.model.dao.BadgeDao
import edu.cnm.deepdive.handsolitaire.model.dao.GameDao
import edu.cnm.deepdive.handsolitaire.model.dao.UserDao
import edu.cnm.deepdive.handsolitaire.model.entity.Badge
import edu.cnm.deepdive.handsolitaire.model.entity.Game
import edu.cnm.deepdive.handsolitaire.model.entity.User
import kotlin.time.Instant

@Database(
    entities = [User::class, Game::class, Badge::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(HandSolitaireDatabase::class)
abstract class HandSolitaireDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getGameDao(): GameDao

    abstract fun getBadgeDao(): BadgeDao

    companion object {
        const val NAME = "hand_solitaire_db"

        @TypeConverter
        @JvmStatic
        fun instantToLong(instant: Instant?): Long? =
            instant?.toEpochMilliseconds()

        @TypeConverter
        @JvmStatic
        fun longToInstant(epochMilliseconds: Long?): Instant? =
            epochMilliseconds?.let { Instant.fromEpochMilliseconds(it) }

    }

}
