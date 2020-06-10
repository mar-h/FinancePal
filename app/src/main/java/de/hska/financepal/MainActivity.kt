package de.hska.financepal

import android.app.Activity
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
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.db.InstrumentListAdapter
import de.hska.financepal.entity.Instrument
import de.hska.financepal.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var instrumentDao: InstrumentDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val anleihe = Instrument(18, "Anleihe",
                                        "Argentinien", "39.16"," 177880.00")

        val instruments: List<Instrument> = emptyList()
        instruments.toMutableList().addAll(listOf(anleihe, anleihe, anleihe))

        db = AppDatabase.getDatabase(this)
        instrumentDao = db.instrumentDao()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = InstrumentListAdapter(instruments,this)
        recyclerView.adapter = adapter
        instrumentDao.getAllInstruments()


        val fab2 = findViewById<FloatingActionButton>(R.id.fab2)
        fab2.setOnClickListener {
            val intent = Intent(this@MainActivity, NewInstrumentActivity::class.java)
            startActivityForResult(intent, Activity.RESULT_OK)
            @Override
            fun onClick(view: View) {
                startActivity(Intent(this@MainActivity, NewInstrumentActivity::class.java))
            }
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