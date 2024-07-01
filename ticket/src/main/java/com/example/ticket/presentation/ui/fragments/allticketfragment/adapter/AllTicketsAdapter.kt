package com.example.ticket.presentation.ui.fragments.allticketfragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ticket.R
import com.example.ticket.domain.model.allteickets.Ticket
import com.example.ticket.databinding.ItemAllTicketBinding
import java.time.Duration
import java.time.LocalDateTime

class AllTicketsAdapter(val context: Context):ListAdapter<Ticket, AllTicketsAdapter.AllTicketsViewHolder>(AllTicketsDiff()) {

    inner class AllTicketsViewHolder(private val binding: ItemAllTicketBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Ticket) {
            if(model.badge != null) {
                binding.cardUdobnyi.visibility = View.VISIBLE
                binding.tvUdob.text = model.badge
            }
            val departureTime = model.departure.date.substring(11, 16)
            val arrivalTime = model.arrival.date.substring(11, 16)

            binding.tvTime.text = "$departureTime - $arrivalTime"
            binding.tvPrice.text = model.price.value.toString() + " \u20BD"
            binding.tvAer.text = model.arrival.airport
            binding.tvVko.text = model.departure.airport

            val departureDateTime = LocalDateTime.parse(model.departure.date)
            val arrivalDateTime = LocalDateTime.parse(model.arrival.date)
            val flightDuration = Duration.between(departureDateTime, arrivalDateTime)
            val hours = flightDuration.toHours()
            val minutes = flightDuration.minusHours(hours).toMinutes()

            val flightTime = String.format(context.getString(R.string.date_line), hours, minutes)
            val transferText = if (model.hasTransfer) "" else context.getString(R.string.noTransverrs)
            val flightInfo = if (model.hasTransfer) flightTime else "$flightTime / $transferText"
            binding.tvArrive.text = flightInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTicketsViewHolder {
        return AllTicketsViewHolder(ItemAllTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AllTicketsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class AllTicketsDiff:DiffUtil.ItemCallback<Ticket>() {
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }

}
