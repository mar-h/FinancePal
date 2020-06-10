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
        val itemView = inflater.inflate(R.layout.instrument_row, parent, false)
        return InstrumentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InstrumentViewHolder, position: Int) {
        val current = instruments[position]
        holder.typ.text = current.typ
        holder.name.text = current.name
        holder.kurs.text = current.kurs.toString()
        holder.wert.text = current.wert.toString()
    }

    override fun getItemCount() = instruments.size

    inner class InstrumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typ: TextView = itemView.findViewById(R.id.typ)
        val name: TextView = itemView.findViewById(R.id.name)
        val kurs: TextView = itemView.findViewById(R.id.kurs)
        val wert: TextView = itemView.findViewById(R.id.wert)
        // val instrumentItemView: TextView = itemView.findViewById(R.id.textView)
    }
}