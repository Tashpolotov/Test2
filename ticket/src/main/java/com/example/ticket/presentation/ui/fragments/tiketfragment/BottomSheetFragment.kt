package com.example.ticket.presentation.ui.fragments.tiketfragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core_utils.SharedPref
import com.example.ticket.R
import com.example.ticket.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private val binding by viewBinding(FragmentBottomSheetBinding::bind)
    private lateinit var sharedPref: SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = SharedPref(requireContext())
        setupDialog()
        setupListeners()
        setInitialValues()
    }

    private fun setupDialog() {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels

        val bottomSheet = dialog as? BottomSheetDialog
        bottomSheet?.behavior?.peekHeight = screenHeight
    }

    private fun setupListeners() {
        binding.imgStrong.setOnClickListener {
            findNavController().navigate(R.id.mockFragment)
            dialog?.dismiss()
        }

        binding.imgHot.setOnClickListener {
            findNavController().navigate(R.id.mockFragment)
            dialog?.dismiss()
        }

        binding.imgWeekend.setOnClickListener {
            findNavController().navigate(R.id.mockFragment)
            dialog?.dismiss()
        }

        binding.imgWhere.setOnClickListener {
            val textToSave = getString(R.string.asdd)
            binding.etWhere.setText(textToSave)
            sharedPref.selectedName = textToSave
            findNavController().navigate(R.id.searchCityFragment)
            dialog?.dismiss()
        }

        binding.const1.setOnClickListener {
            binding.etWhere.setText(binding.tvStambul.text)
            findNavController().navigate(R.id.searchCityFragment)
            sharedPref.selectedName = binding.tvStambul.text.toString()
            dialog?.dismiss()
        }

        binding.const2.setOnClickListener {
            binding.etWhere.setText(binding.tvSochi.text)
            findNavController().navigate(R.id.searchCityFragment)
            sharedPref.selectedName = binding.tvSochi.text.toString()
            dialog?.dismiss()
        }

        binding.const3.setOnClickListener {
            binding.etWhere.setText(binding.tvPhucket.text)
            findNavController().navigate(R.id.searchCityFragment)
            sharedPref.selectedName = binding.tvPhucket.text.toString()
            dialog?.dismiss()
        }
    }

    private fun setInitialValues() {
        val selectedCity = sharedPref.selectedUserCity ?: getString(R.string.minsk)
        binding.etLocationCity.setText(selectedCity)
    }
}
