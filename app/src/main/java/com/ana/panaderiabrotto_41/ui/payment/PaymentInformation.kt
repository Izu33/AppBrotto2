package com.ana.panaderiabrotto_41.ui.payment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ana.panaderiabrotto_41.R

class PaymentInformation : Fragment() {

    companion object {
        fun newInstance() = PaymentInformation()
    }

    private lateinit var viewModel: PaymentInformationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment_information, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PaymentInformationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}