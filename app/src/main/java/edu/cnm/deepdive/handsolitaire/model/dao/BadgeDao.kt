package edu.cnm.deepdive.handsolitaire.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import edu.cnm.deepdive.handsolitaire.model.entity.Badge

@Dao
interface BadgeDao {

    @Insert
    suspend fun insert(badge: Badge): Long

    @Insert
    suspend fun insert(badges: Collection<Badge>): List<Long>

    @Update
    suspend fun update(badge: Badge): Int

    @Query("SELECT * FROM badge WHERE badge_id = :badgeId")
    fun select(badgeId: Long): LiveData<Badge>

    @Query("SELECT * FROM badge WHERE user_id = :userId ORDER BY earned_at DESC")
    fun selectByUser(userId: Long): LiveData<List<Badge>>

    // Badges that haven't been spent yet (spent_at is null)
    @Query("SELECT * FROM badge WHERE user_id = :userId AND spent_at IS NULL ORDER BY earned_at ASC")
    fun selectUnspentByUser(userId: Long): LiveData<List<Badge>>

}