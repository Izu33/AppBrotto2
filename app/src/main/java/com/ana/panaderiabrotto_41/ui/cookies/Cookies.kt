package com.ana.panaderiabrotto_41.ui.cookies

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.ana.panaderiabrotto_41.MainActivity
import com.ana.panaderiabrotto_41.R
import com.ana.panaderiabrotto_41.databinding.FragmentCookiesBinding
import com.ana.panaderiabrotto_41.ui.home.HomeViewModel

class Cookies : Fragment() {

    private var _binding: FragmentCookiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cookiesViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentCookiesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*binding.btnR.setOnClickListener {
            findNavController().navigate(R.id.action_cookies_to_navigation_home)
        }*/

        return inflater.inflate(R.layout.fragment_cookies, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}