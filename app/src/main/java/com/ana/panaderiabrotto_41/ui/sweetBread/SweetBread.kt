package com.ana.panaderiabrotto_41.ui.sweetBread

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ana.panaderiabrotto_41.R
import com.ana.panaderiabrotto_41.databinding.FragmentSweetBreadBinding
import com.ana.panaderiabrotto_41.ui.home.HomeViewModel

class SweetBread : Fragment() {

    private var _binding: FragmentSweetBreadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val cookiesViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentSweetBreadBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return inflater.inflate(R.layout.fragment_sweet_bread, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}