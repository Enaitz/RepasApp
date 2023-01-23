package com.example.repasapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repasapp.model.Cotxe
import com.example.repasapp.model.Tractors
import com.example.repasapp.repositori.Repositori
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect


class MotorViewModel: ViewModel() {

    var cotxe: LiveData<List<Cotxe>>? = null


    var tractors: LiveData<List<Tractors>>? = null


    //insert cotxe
    fun newCotxe(context: Context,any:Int,combustible:String,marca:String,cavalls:Int) {

        var cotxeVM=Cotxe(any,combustible,marca,cavalls)
        Repositori.insertCotxe(context,cotxeVM)
    }

    //insert tractor
    fun newTractor(context: Context,any:Int,marca:String,cavalls:Int) {

        var tractorVM=Tractors(any,marca,cavalls)
        Repositori.inserttractor(context,tractorVM)
    }

    //sql cotxes by marca
    fun obtenirCotxesPerMarca(context: Context, marca: String) : LiveData<List<Cotxe>>? {
        cotxe = Repositori.getCotxeByMarca(context,marca)
        return cotxe
    }


    //sql tractors
    fun obtenirTractors(context: Context) : LiveData<List<Tractors>>? {
        tractors = Repositori.getTractors(context)
        return tractors
    }
}