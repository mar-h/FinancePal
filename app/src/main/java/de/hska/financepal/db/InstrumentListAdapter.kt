package de.hska.financepal.db

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hska.financepal.R
import de.hska.financepal.entity.Instrument

class InstrumentListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<InstrumentListAdapter.InstrumentViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var instruments = emptyList<Instrument>()

    inner class InstrumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val instrumentItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return InstrumentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InstrumentViewHolder, position: Int) {
        val current = instruments[position]
        holder.instrumentItemView.text = current.name
    }

    internal fun setInstruments(instruments: List<Instrument>) {
        this.instruments = instruments
        notifyDataSetChanged()
    }

    override fun getItemCount() = instruments.size
}