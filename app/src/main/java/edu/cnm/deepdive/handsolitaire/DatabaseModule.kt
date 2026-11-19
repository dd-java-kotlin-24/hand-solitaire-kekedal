package edu.cnm.deepdive.handsolitaire.service

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.cnm.deepdive.handsolitaire.model.entity.Badge
import edu.cnm.deepdive.handsolitaire.model.entity.Game
import edu.cnm.deepdive.handsolitaire.model.entity.User
import edu.cnm.deepdive.handsolitaire.model.dao.BadgeDao
import edu.cnm.deepdive.handsolitaire.model.dao.GameDao
import edu.cnm.deepdive.handsolitaire.model.dao.UserDao

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