package de.hska.financepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.entity.Instrument
import kotlinx.android.synthetic.main.content_main.*

class NewInstrumentActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var instrumentDao: InstrumentDao
    private lateinit var typ: EditText
    private lateinit var name: EditText
    private lateinit var kurs: EditText
    private lateinit var wert: EditText
    private lateinit var button: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_instrument)

        db = AppDatabase.getDatabase(this)
        instrumentDao = db?.instrumentDao()

        typ = findViewById(R.id.edit_bond)
        name = findViewById(R.id.edit_name)
        kurs = findViewById(R.id.edit_name)
        wert = findViewById(R.id.edit_wert)
        button = findViewById(R.id.button_save)

        val instrument = Instrument(1, "8B1R23", "Aktie", "883.00","44150.00")
        db.instrumentDao().insert(instrument)



        button.setOnClickListener {
            val eingabe = Instrument(2, typ.text.toString(), name.text.toString(),
                kurs.text.toString(), wert.text.toString())
            instrumentDao.insert(eingabe)
            startActivity(Intent(this@NewInstrumentActivity, MainActivity::class.java))
        }
    }
}