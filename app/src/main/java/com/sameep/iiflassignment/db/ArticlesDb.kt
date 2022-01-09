package com.sameep.iiflassignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sameep.iiflassignment.db.dao.ArticlesDao
import com.sameep.iiflassignment.rest.response.ResponseItem

@Database(entities = [ResponseItem::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ArticlesDb:RoomDatabase() {

    abstract fun articleDao():ArticlesDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ArticlesDb? = null

        fun getDatabase(context: Context): ArticlesDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticlesDb::class.java,
                    "article_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}