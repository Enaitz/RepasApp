package com.example.repasapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.ColumnInfo
import com.example.repasapp.R
import com.example.repasapp.databinding.FragmentMotorBinding
import com.example.repasapp.viewmodel.MotorViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MotorFragment : Fragment() {
    private lateinit var binding: FragmentMotorBinding

    //    private val myViewModel: MotorViewModel by activityViewModels() {
//        MyViewModelFactory(MyApplication.repository!!)
//    }
    private lateinit var motorViewModel: MotorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_motor, container, false
        )

        motorViewModel = ViewModelProvider(this).get(MotorViewModel::class.java)

        binding.buttonInsert.setOnClickListener {
            val any = binding.editTextAny.text.toString().toInt()
            val combustible = binding.editTextCombustible.text.toString()
            val marca = binding.editTextMarca.text.toString()
            val cavalls = binding.editTextCavalls.text.toString().toInt()
            if (binding.checkBoxTractor.isChecked) {
                motorViewModel.newTractor(requireContext(), any, marca, cavalls)
            } else {
                motorViewModel.newCotxe(requireContext(), any, combustible, marca, cavalls)
            }

        }

        binding.buttonGetCotxes.setOnClickListener{
            val marca = binding.editTextMarca.text.toString()

//            loginViewModel.getLoginDetails(context, strUsername)!!.observe(this, Observer {

            motorViewModel.obtenirCotxesPerMarca(requireContext(),marca)?.observe(viewLifecycleOwner,Observer{cotxesLlistat->
                Toast.makeText(requireContext(),"Any: ${cotxesLlistat[0].any.toString()}, Combustible: ${cotxesLlistat[0].combustible.toString()}, Marca: ${cotxesLlistat[0].marca.toString()}, Cavalls: ${cotxesLlistat[0].cavalls}", Toast.LENGTH_SHORT).show()
            })


        }

        // Inflate the layout for this fragment
        return binding.root
    }


}