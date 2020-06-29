package de.hska.financepal.db

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hska.financepal.R
import de.hska.financepal.entity.Instrument
import kotlin.math.round
import kotlin.random.Random.Default.nextDouble

class InstrumentListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<InstrumentListAdapter.InstrumentViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var instruments = emptyList<Instrument>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstrumentViewHolder {
        val view = inflater.inflate(R.layout.instrument_row, parent, false)
        return InstrumentViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: InstrumentViewHolder, position: Int) {
        val currency = " "+instruments[position].curr

        holder.typ.text = instruments[position].typ + " "+ instruments[position].name
        holder.kurs.text = "Kurs: "+instruments[position].kurs.toString()+currency
        holder.anzahl.text = "Anzahl: "+instruments[position].anzahl.toString()
        holder.wert.text = "Kaufwert: "+instruments[position].wert.toString()+currency
        holder.kurswert.text = "Kurswert: "+instruments[position].kurswert.toString()+currency
        holder.gewinn.text = "Gewinn/Verlust: "+instruments[position].gewinn.toString()+currency
        holder.rendite.text = "Rendite: "+instruments[position].rendite.toString()+" %"
    }

    internal fun getInstrumentAtPosition(position: Int): Instrument {
        return instruments.get(position)
    }

    internal fun removeAt(position: Int) {
        this.instruments.toMutableList().removeAt(position)
        this.instruments.toList()
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    internal fun setInstruments(instruments: List<Instrument>) {
        this.instruments = instruments
        notifyDataSetChanged()
    }

    internal fun update(instruments: List<Instrument>) {
        this.instruments = instruments
        this.instruments.forEach { instrument: Instrument ->
            instrument.kurs = instrument.kurs+ round(nextDouble(8.00)*100)/100
            instrument.kurswert = round((instrument.kurs*instrument.anzahl)*100)/100
            instrument.gewinn = round((instrument.kurswert-instrument.wert)*100)/100
            instrument.rendite = round((instrument.gewinn/instrument.wert)*100)/100*100
        }
        notifyDataSetChanged()
    }

    internal fun refresh() {
        notifyDataSetChanged()
    }

    internal fun setInstrument(instrument: Instrument) {
        this.instruments.toMutableList().add(instrument)
        notifyItemInserted(instruments.size -1)
    }

    override fun getItemCount() = instruments.size

    inner class InstrumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typ: TextView = itemView.findViewById(R.id.typ)
        val kurs: TextView = itemView.findViewById(R.id.kurs)
        val anzahl: TextView = itemView.findViewById(R.id.anzahl)
        val kurswert: TextView = itemView.findViewById(R.id.kurswert)
        val wert: TextView = itemView.findViewById(R.id.wert)
        val gewinn: TextView = itemView.findViewById(R.id.gewinn)
        val rendite: TextView = itemView.findViewById(R.id.rendite)
    }
}