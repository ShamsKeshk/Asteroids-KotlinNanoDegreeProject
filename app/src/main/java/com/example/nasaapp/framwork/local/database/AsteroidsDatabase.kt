package com.example.nasaapp.framwork.local.database

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nasaapp.framwork.local.converts.CloseApproachConvertors
import com.example.nasaapp.framwork.local.converts.DiameterConvertors
import com.example.nasaapp.framwork.local.converts.LinksConvertor
import com.example.nasaapp.framwork.local.data.NearEarthEntity


@Database(entities = [NearEarthEntity::class], version = 1, exportSchema = false)
@TypeConverters(DiameterConvertors::class,CloseApproachConvertors::class,LinksConvertor::class)
abstract class AsteroidsDatabase: RoomDatabase() {

    companion object{

        private const val DATABASE_NAME = "asteroids.db"

        @Volatile
        private var INSTANCE: AsteroidsDatabase? = null

        private fun create(context: Context) : AsteroidsDatabase =
            Room.databaseBuilder(context,AsteroidsDatabase::class.java,DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): AsteroidsDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = create(context)
                }
                INSTANCE = instance
                return instance
            }
        }
    }


    abstract fun getAsteroidsDao(): AsteroidsDao

}