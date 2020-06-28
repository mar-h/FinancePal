package de.hska.financepal

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.entity.Instrument
import de.hska.financepal.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var instrumentDao: InstrumentDao
    private lateinit var instruments: List<Instrument>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = this.getSharedPreferences("financePal", Context.MODE_PRIVATE)
        val Kontostand : Double = prefs.getFloat("balance",500000.00F).toDouble()
        textViewKontostand.text = Kontostand.toString()

        //Tabs
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Teile dein Portfolio mit deinen Freunden", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}