package de.hska.financepal

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentListAdapter
import de.hska.financepal.entity.Instrument
import de.hska.financepal.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private val newInstrumentActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val anleihe: Instrument = Instrument(18, "A1ZJDD", "Argentinien",
                                        "Anleihe", 45998.16, 177880,
                                        33.95, 61818.38, "EUR", 34.39)
        var instrumente: List<Instrument> = emptyList()*/

        var instruments: List<Instrument> = emptyList()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = InstrumentListAdapter(this)
        recyclerView.adapter = adapter
/*
        instrumente.toMutableList().add(anleihe)
*/


        /*instrumentViewModel = ViewModelProvider(this).get(InstrumentViewModel::class.java)
        instrumentViewModel.allInstruments.observe(this, Observer { instruments ->
            instruments?.let { adapter.setInstruments(it) }
        })*/

        val fab2 = findViewById<FloatingActionButton>(R.id.fab2)
        fab2.setOnClickListener {
            val intent = Intent(this@MainActivity, NewInstrumentActivity::class.java)
            startActivity(intent)
            /*@Override
            fun onClick(view: View) {
                startActivity(Intent(this@MainActivity, NewInstrumentActivity::class.java))
            }*/
        }


        /*val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Teile dein Portfolio mit deinen Freunden", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
    }
}