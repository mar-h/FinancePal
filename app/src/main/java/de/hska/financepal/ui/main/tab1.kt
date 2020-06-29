package de.hska.financepal.ui.main

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hska.financepal.R
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.db.InstrumentListAdapter
import de.hska.financepal.db.SwipeToDeleteCallback
import de.hska.financepal.entity.Instrument
import kotlinx.android.synthetic.main.fragment_tab2.*
import kotlinx.android.synthetic.main.instrument_row.*
import kotlin.math.round

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tab1.newInstance] factory method to
 * create an instance of this fragment.
 */
class tab1 : Fragment() {

    private lateinit var db: AppDatabase
    private lateinit var instrumentDao: InstrumentDao
    private lateinit var instruments: List<Instrument>
    private lateinit var adapter: InstrumentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tab1, container, false)

        //Alex' Room-DB und RecyclerView

        db = AppDatabase.getDatabase(rootView.context)
        instrumentDao = db.instrumentDao()
        instruments = instrumentDao.getAllInstruments()
        adapter = InstrumentListAdapter(rootView.context)
        adapter.setInstruments(instruments)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        val swipeHandler = object : SwipeToDeleteCallback(rootView.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val prefs = activity?.getSharedPreferences("financePal", Context.MODE_PRIVATE)
                prefs?.let {

                    val currentBalance = round(prefs.getFloat("balance",500000.00F)*100)/100
                    val newBalance = (currentBalance + round(adapter.getInstrumentAtPosition(viewHolder.position).kurswert*100)/100).toFloat()
                    prefs.edit().putFloat("balance",newBalance).apply()
                    activity?.findViewById<TextView>(R.id.textViewKontostand)?.text = newBalance.toString()

                    instrumentDao.delete(adapter.getInstrumentAtPosition(viewHolder.position))
                    adapter.removeAt(viewHolder.position)
                    adapter.setInstruments(instrumentDao.getAllInstruments())
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        return rootView
    }
    val handler = Handler()

    fun startTimer() {
        handler.postDelayed(Runnable { runnable() }, 5000)
    }

    fun runnable() {
        adapter.update(instrumentDao.getAllInstruments())
        handler.postDelayed(Runnable { runnable() }, 10000)
    }

    override fun onResume() {
        super.onResume()
        runnable()
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tab1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tab1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}