package com.ana.panaderiabrotto_41.ui.christmas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ana.panaderiabrotto_41.R
import com.ana.panaderiabrotto_41.databinding.FragmentChristmasBinding
import com.ana.panaderiabrotto_41.ui.home.HomeViewModel

class Christmas : Fragment() {

    private var _binding: FragmentChristmasBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ChristmasViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cookiesViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentChristmasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return inflater.inflate(R.layout.fragment_christmas, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChristmasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}