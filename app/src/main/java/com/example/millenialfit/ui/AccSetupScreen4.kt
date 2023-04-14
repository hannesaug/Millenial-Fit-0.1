package com.example.millenialfit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.millenialfit.R
import com.example.millenialfit.databinding.FragmentAccSetupScreen3Binding
import com.example.millenialfit.databinding.FragmentAccSetupScreen4Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccSetupScreen4.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccSetupScreen4 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAccSetupScreen4Binding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccSetupScreen4Binding.inflate(inflater,container,false)
        val view = binding.root

        binding.showBmiButton.setOnClickListener {
            val height = binding.heightSpinner.selectedItem.toString().toInt()
            val weight = binding.kgSpinner.selectedItem.toString().toInt()
            val heightWithDecimal = height * 0.01
            val heightM2 = heightWithDecimal * heightWithDecimal
            val BMIresult = weight/heightM2

            binding.BMIResultTextView.text = String.format("%.2f", BMIresult)

        }

        binding.continueButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.profile_screen)
        }

        binding.backButton.setOnClickListener {
            Navigation.findNavController(view).navigateUp()
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
         * @return A new instance of fragment AccSetupScreen4.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccSetupScreen4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}