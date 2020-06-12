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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentViewHolder {
        val view = inflater.inflate(R.layout.instrument_row, parent, false)
        return InstrumentViewHolder(view)
    }

    override fun onBindViewHolder(holder: InstrumentViewHolder, position: Int) {
        holder.typ.text = instruments[position].typ
        holder.name.text = instruments[position].name
        holder.kurs.text = instruments[position].kurs
        holder.wert.text = instruments[position].wert
    }

    internal fun setInstruments(instruments: List<Instrument>) {
        this.instruments = instruments
        notifyDataSetChanged()
    }
    internal fun setInstrument(instrument: Instrument) {
        this.instruments.toMutableList().add(instrument)
        this.instruments.toList()
        notifyDataSetChanged()
    }

    override fun getItemCount() = instruments.size

    inner class InstrumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typ: TextView = itemView.findViewById(R.id.typ)
        val name: TextView = itemView.findViewById(R.id.name)
        val kurs: TextView = itemView.findViewById(R.id.kurs)
        val wert: TextView = itemView.findViewById(R.id.wert)
    }
}