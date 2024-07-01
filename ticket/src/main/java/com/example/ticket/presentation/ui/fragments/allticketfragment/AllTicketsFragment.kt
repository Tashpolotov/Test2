package com.example.ticket.presentation.ui.fragments.allticketfragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core_utils.SharedPref
import com.example.core_utils.base.BaseFragment
import com.example.ticket.R
import com.example.ticket.databinding.FragmentAllTicketsBinding
import com.example.ticket.presentation.ui.fragments.allticketfragment.adapter.AllTicketsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AllTicketsFragment : BaseFragment(R.layout.fragment_all_tickets) {

    private val binding by viewBinding(FragmentAllTicketsBinding::bind)
    private val viewModel by viewModels<AllTicketsViewModel>()
    private lateinit var adapter : AllTicketsAdapter
    @Inject
    lateinit var sharedPref: SharedPref

    override fun initialize() {
        adapter = AllTicketsAdapter(requireContext())
        binding.rv.adapter = adapter
        viewModel.loadAllTickets()

        val selectedName = sharedPref.selectedName
        val selectedUserCity = sharedPref.selectedUserCity ?: getString(R.string.cityMinsk)

        if (selectedName != null && selectedUserCity != null) {
            binding.tvWhere.text = "$selectedUserCity-$selectedName"
        } else if (selectedName != null) {
            binding.tvWhere.text = selectedName
        } else {
            binding.tvWhere.text = selectedUserCity
        }

        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initSubscribers() {
        viewModel.allTickets.collectUIState(
            state = {
                binding.progressBar.visibility = View.VISIBLE
            },
            onSuccess = {
                binding.progressBar.visibility = View.GONE
                binding.constContainer.visibility = View.VISIBLE
                adapter.submitList(it.tickets)
            }
        )
    }
}