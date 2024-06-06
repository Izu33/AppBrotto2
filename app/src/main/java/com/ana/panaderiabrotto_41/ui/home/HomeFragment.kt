package com.ana.panaderiabrotto_41.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ana.panaderiabrotto_41.MainActivity
import com.ana.panaderiabrotto_41.R
import com.ana.panaderiabrotto_41.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*Boton para Galletas*/
        binding.btnCooky.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_cookies)
        }

        /*Boton para Pan Dulce*/
        binding.btnBreadCandy.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_sweetBread)
        }

        /*Boton para Pan Salado*/
        binding.btnBread.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_breadSalad)
        }

        /*Boton para Navideño*/
        binding.btnChristmas.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_christmas)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}