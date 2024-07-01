package com.example.ticket.presentation.ui.fragments.tiketfragment

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core_utils.SharedPref
import com.example.core_utils.base.BaseFragment
import com.example.ticket.R
import com.example.ticket.databinding.FragmentTiketBinding
import com.example.ticket.presentation.ui.fragments.tiketfragment.adapter.MainScreenAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class TiketFragment : BaseFragment(R.layout.fragment_tiket) {

    private val binding by viewBinding(FragmentTiketBinding::bind)
    private val viewModel by viewModels<MainViewModel>()
    private val adapter = MainScreenAdapter()
    @Inject
    lateinit var sharedPref: SharedPref
    override fun initialize() {
        binding.rv.adapter = adapter
        viewModel.loadMainScreen()

        if (sharedPref.selectedUserCity != null) {
            binding.etLocationCity.setText(sharedPref.selectedUserCity)
        } else {
            val city = getString(R.string.minsk)
            binding.etLocationCity.setText(city)
        }
        sharedPref.selectedName?.let { selectedCity ->
            binding.tvWhere.setText(selectedCity)
        }
        binding.tvWhere.setOnClickListener {
            showBottomSheet()
        }

        binding.etLocationCity.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                sharedPref.selectedUserCity = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.cyrillicFilter.value?.let { filter ->
            binding.etLocationCity.filters = arrayOf(filter)
        }
    }

    override fun initSubscribers() {
        viewModel.mainScreen.collectUIState(
            state = {
                binding.progressBar.visibility = View.VISIBLE
            },
            onSuccess = {
                binding.progressBar.visibility = View.GONE
                binding.linearContainer.visibility = View.VISIBLE
                binding.tvMusic.visibility = View.VISIBLE
                binding.tvFirst.visibility = View.VISIBLE
                binding.btn.visibility = View.VISIBLE
                adapter.submitList(it.offers)
            }
        )
    }
    private fun showBottomSheet() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
    }
}