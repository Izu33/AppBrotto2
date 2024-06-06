package com.ana.panaderiabrotto_41.ui.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ana.panaderiabrotto_41.R
import com.ana.panaderiabrotto_41.databinding.FragmentPerfilBinding

/*enum class infoPerfil2{
    BASIC
}*/

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        /*Boton para Cerrar Sesión*/
        binding.btnCSesion.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_mainActivity)
        }

        /*val bundle:Bundle? = intent.extras
        val bundle?.getString("email")
        val bundle?.getString("nombre")
        setup(email ?:"", nombre ?:"")*/

        return root
    }

    /*private fun setup(email: String,nombre:String ){
        textViewNombre.text = nombre
        textViewCorreo.text = email

        binding.btnCSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
            //findNavController().navigate(R.id.action_navigation_notifications_to_mainActivity)
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}