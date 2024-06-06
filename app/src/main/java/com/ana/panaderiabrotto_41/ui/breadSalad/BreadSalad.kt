package com.ana.panaderiabrotto_41.ui.breadSalad

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ana.panaderiabrotto_41.R
import com.ana.panaderiabrotto_41.databinding.FragmentBreadSaladBinding
import com.ana.panaderiabrotto_41.ui.home.HomeViewModel

class BreadSalad : Fragment() {

    private var _binding: FragmentBreadSaladBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cookiesViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentBreadSaladBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*Boton para Descripción del Producto*/
        binding.idProducto.setOnClickListener {
            findNavController().navigate(R.id.descriptionBreadSalad)
        }

        return inflater.inflate(R.layout.fragment_bread_salad, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}