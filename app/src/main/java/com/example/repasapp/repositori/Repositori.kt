package com.example.repasapp.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.repasapp.databases.MotorDatabase
import com.example.repasapp.model.Cotxe
import com.example.repasapp.model.Tractors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class Repositori {


    companion object {

        var motorDatabase: MotorDatabase? = null

        var cotxe: LiveData<List<Cotxe>>? = null

        var tractor: LiveData<List<Tractors>>? = null


        fun initializeDB(context: Context): MotorDatabase {
            return MotorDatabase.getDatabase(context)
        }

        //INSERT cotxe
        fun insertCotxe(context: Context, cotxe: Cotxe) {

            motorDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                motorDatabase!!.motorDao().addCotxe(cotxe)
            }
        }

        //INSERT tractor
        fun inserttractor(context: Context, tractors: Tractors) {

            motorDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                motorDatabase!!.motorDao().addTractor(tractors)
            }
        }


        //SQL cotxe by marca

        fun getCotxeByMarca(context: Context, marca: String): LiveData<List<Cotxe>>? {

            motorDatabase = initializeDB(context)

            cotxe = motorDatabase!!.motorDao().getCotxesByMarca(marca)

            return cotxe
        }

        //SQL tractor
        fun getTractors(context: Context): LiveData<List<Tractors>>? {

            motorDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                tractor = motorDatabase!!.motorDao().getTractors()
            }
            return tractor
        }
    }

}