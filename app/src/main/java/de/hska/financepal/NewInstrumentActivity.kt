package de.hska.financepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.entity.Instrument

class NewInstrumentActivity : AppCompatActivity() {

    private lateinit var typ: EditText
    private lateinit var name: EditText
    private lateinit var kurs: EditText
    private lateinit var wert: EditText
    private lateinit var button: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_instrument)

        val db: AppDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java,
            "FiPal")
            .allowMainThreadQueries()
            .build()

        db.instrumentDao().deleteAll()

        typ = findViewById(R.id.edit_bond)
        name = findViewById(R.id.edit_name)
        kurs = findViewById(R.id.edit_name)
        wert = findViewById(R.id.edit_wert)
        button = findViewById<Button>(R.id.button_save)

        val instrument = Instrument(1, "8B1R23", "Aktie", 883.00,44150.00)

        db.instrumentDao().insert(instrument)

        button.setOnClickListener {

            val instrument = Instrument(99, typ.text.toString(), name.text.toString(), kurs.text.toString().toDouble(),
            wert.text.toString().toDouble())
            db.instrumentDao().insert(instrument)
            startActivity(Intent(this@NewInstrumentActivity, MainActivity::class.java))
        }
    }

    companion object {

    }
}