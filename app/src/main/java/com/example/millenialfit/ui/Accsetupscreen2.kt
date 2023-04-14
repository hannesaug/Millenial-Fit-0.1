package com.example.millenialfit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.millenialfit.R
import com.example.millenialfit.databinding.FragmentAccsetupscreen2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Accsetupscreen2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Accsetupscreen2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAccsetupscreen2Binding?=null
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
        _binding = FragmentAccsetupscreen2Binding.inflate(inflater,container,false)
        val view = binding.root
        var maleBoolean = false
        var femaleBoolean = false

        binding.maleCardView1.setOnClickListener {
            maleBoolean = !maleBoolean
            when(maleBoolean){
                false -> {
                    binding.maleCardView1.setCardBackgroundColor(resources.getColor(com.google.android.material.R.color.m3_ref_palette_dynamic_neutral50))
                }
                true -> {
                    binding.maleCardView1.setCardBackgroundColor(resources.getColor(R.color.purple_main))

                }
            }
        }

        binding.femaleCardview2.setOnClickListener {
            femaleBoolean = !femaleBoolean
            when(femaleBoolean){
                false -> {
                    binding.femaleCardview2.setCardBackgroundColor(resources.getColor(com.google.android.material.R.color.m3_ref_palette_dynamic_neutral50))
                }
                true -> {
                    binding.femaleCardview2.setCardBackgroundColor(resources.getColor(R.color.purple_main))

                }
            }
        }

        binding.button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.accSetupScreen3)
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
         * @return A new instance of fragment Accsetupscreen2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Accsetupscreen2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}