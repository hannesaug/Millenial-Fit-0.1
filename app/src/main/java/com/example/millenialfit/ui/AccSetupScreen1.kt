package com.example.millenialfit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.millenialfit.R
import com.example.millenialfit.databinding.FragmentAccSetupScreen1Binding
import com.example.millenialfit.databinding.FragmentAccsetupscreen2Binding

/**
 * A simple [Fragment] subclass.
 * Use the [AccSetupScreen1.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccSetupScreen1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAccSetupScreen1Binding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccSetupScreen1Binding.inflate(inflater,container,false)
        val view = binding.root

        binding.beginnerTextButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.accsetupscreen2)
        }

        binding.intermediateTextButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.accsetupscreen2)
        }

        binding.button3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.accsetupscreen2)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccSetupScreen1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccSetupScreen1().apply {
                arguments = Bundle().apply {

                }
            }
    }
}