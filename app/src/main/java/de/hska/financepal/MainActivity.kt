package de.hska.financepal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hska.financepal.db.InstrumentListAdapter
import de.hska.financepal.db.InstrumentViewModel
import de.hska.financepal.entity.Instrument
import de.hska.financepal.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private val newInstrumentActivityRequestCode = 1
    private lateinit var instrumentViewModel: InstrumentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = InstrumentListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        instrumentViewModel = ViewModelProvider(this).get(InstrumentViewModel::class.java)
        instrumentViewModel.allInstruments.observe(this, Observer { instruments ->
            instruments?.let { adapter.setInstruments(it) }
        })

        val fab2 = findViewById<FloatingActionButton>(R.id.fab2)
        fab2.setOnClickListener {
            val intent = Intent(this@MainActivity, NewInstrumentActivity::class.java)
            startActivityForResult(intent, newInstrumentActivityRequestCode)
        }


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

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newInstrumentActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewInstrumentActivity.EXTRA_REPLY)?.let {
                val instrument = Instrument(it)
                instrumentViewModel.insert(instrument)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }*/
}