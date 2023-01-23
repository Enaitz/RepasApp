package com.example.repasapp.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repasapp.model.Cotxe
import com.example.repasapp.model.Tractors


@Database(
    entities = [Cotxe::class, Tractors::class],
    version = 1,
    exportSchema = false
)


abstract class MotorDatabase  : RoomDatabase(){
    abstract fun motorDao() : MotorDao

    companion object {

        @Volatile
        private var INSTANCE: MotorDatabase? = null

        fun getDatabase(context: Context): MotorDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): MotorDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MotorDatabase::class.java,
                "motor_database"
            )
                .build()
        }
    }
}