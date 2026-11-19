package edu.cnm.deepdive.handsolitaire.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import edu.cnm.deepdive.handsolitaire.model.entity.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insert(game: Game): Long

    @Update
    suspend fun update(game: Game): Int

    @Delete
    suspend fun delete(game: Game): Int

    // Newest games first
    @Query("SELECT * FROM game WHERE game_id = :gameId")
    fun select(gameId: Long): LiveData<Game>

    // Best winning time (0 cards remaining, finished, lowest duration)
    @Query("""
        SELECT
          * 
        FROM game 
        WHERE
          user_id = :userId
          AND level = :level
          AND finished = 1 
          AND cards_remaining = 0 
        ORDER BY 
          duration ASC 
        LIMIT 1
    """)
    fun selectBestWinningTime(level: Int, userId: Long): LiveData<Game?>


}