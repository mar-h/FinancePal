package de.hska.financepal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.db.InstrumentListAdapter
import de.hska.financepal.entity.Instrument
import de.hska.financepal.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.instrument_row.*

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var instrumentDao: InstrumentDao
    private lateinit var instruments: List<Instrument>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getDatabase(this)
        instrumentDao = db.instrumentDao()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        /*val anleihe = Instrument( 1,"Anleihe","Argentinien", "39.16"," 177880.00")
        val aktie = Instrument( 2, "Aktie", "Daimler", "69.65", "120450.80")
        val gold = Instrument(3, "Rohstoff", "Gold", "1698.77", "87439.79")*/
        instruments = instrumentDao.getAllInstruments()
        val adapter = InstrumentListAdapter(this)
        adapter.setInstruments(instruments)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        // instrumentDao.insertALL(instruments)
        // recyclerView.showContextMenu()

        val fab2 = findViewById<FloatingActionButton>(R.id.fab2)
        fab2.setOnClickListener {
            val intent = Intent(this@MainActivity, NewInstrumentActivity::class.java)
            startActivityForResult(intent, Activity.RESULT_OK)
        }

        /*val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)*/
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Teile dein Portfolio mit deinen Freunden", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val instrument = Instrument(data!!.getIntExtra("id", -1),
            data.getStringExtra("typ"),
            data.getStringExtra("name"),
            data.getStringExtra("kurs"),
            data.getStringExtra("wert"))

        var instruments: List<Instrument>
        instruments = listOf(instrument)
        val adapter = InstrumentListAdapter(this)
        adapter.setInstruments(instruments)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
*/
}