package edu.cnm.deepdive.handsolitaire.service

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    fun provideDatabase(@ApplicationContext context : Context): HandSolitaireDatabase {
        return Room.databaseBuilder(context, HandSolitaireDatabase::class.java, HandSolitaireDatabase.NAME)
            .build()
    }





}