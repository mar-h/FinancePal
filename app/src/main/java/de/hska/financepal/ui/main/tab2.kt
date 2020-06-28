package de.hska.financepal.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import de.hska.financepal.R
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.entity.Instrument
import kotlinx.android.synthetic.main.fragment_tab2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var instrumentDao : InstrumentDao


/**
 * A simple [Fragment] subclass.
 * Use the [tab2.newInstance] factory method to
 * create an instance of this fragment.
 */
class tab2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.applicationContext?.let {
            val db = AppDatabase.getDatabase(it)
            instrumentDao = db.instrumentDao()
        }

        button_save.setOnClickListener {
            val typ = typ.getSelectedItem().toString()
            val name = name.text.toString()
            val anzahl = anzahl.text.toString()
            val kurs = kurs.text.toString()
            val curr = curr.getSelectedItem().toString()
            val pattern = "\\d+".toRegex()

            fun isInt(string: String) : Boolean {
                return string.matches(pattern)
            }

            fun isDouble(string: String) : Boolean {
                return !string.matches(pattern)
            }

            if (isInt(anzahl)==true && isDouble(kurs)==true) {
                instrumentDao.insert(Instrument(typ, name, anzahl.toInt(), kurs.toDouble(), curr))
                Snackbar.make(it, "Neues Finanzinstrument hinzugefügt!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            else {
                Snackbar.make(it, "Fehler beim Hinzufügen! Datenformat kontrollieren", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

        }
    }

companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab2.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        tab2().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
}
}
