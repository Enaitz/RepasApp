package com.example.repasapp.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.repasapp.model.Cotxe
import com.example.repasapp.model.Tractors
import kotlinx.coroutines.flow.Flow

@Dao
interface MotorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCotxe(cotxe: Cotxe)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTractor(tractors: Tractors)

    @Query("SELECT * FROM Car WHERE brand =:marca ORDER BY brand DESC")
    fun getCotxesByMarca(marca:String): LiveData<List<Cotxe>>

    @Query("SELECT * FROM Tractors ORDER BY year DESC")
    fun getTractors(): LiveData<List<Tractors>>

}