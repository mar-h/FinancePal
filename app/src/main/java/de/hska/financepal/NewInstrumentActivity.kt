package de.hska.financepal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import de.hska.financepal.db.AppDatabase
import de.hska.financepal.db.InstrumentDao
import de.hska.financepal.db.InstrumentListAdapter
import de.hska.financepal.entity.Instrument

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

        typ = findViewById(R.id.typ)
        name = findViewById(R.id.name)
        kurs = findViewById(R.id.kurs)
        wert = findViewById(R.id.wert)
        button = findViewById(R.id.button_save)
        db = AppDatabase.getDatabase(this)

        button.setOnClickListener {

            val typ = typ.text.toString()
            val name = name.text.toString()
            val kurs = kurs.text.toString()
            val wert = wert.text.toString()

            val data = Intent()
            data.putExtra("typ",typ)
            data.putExtra("name", name)
            data.putExtra("kurs", kurs)
            data.putExtra("wert", wert)
            val id = intent.getIntExtra("id", -1)
            if (id !=-1) {
                data.putExtra("id", id)
            }

            // db.instrumentDao().insert(Instrument(id, name, typ, kurs, wert))
            Log.wtf("NewInstrumentActivity", "Finanzinstrument: $typ $name $kurs $wert")
            val adapter = InstrumentListAdapter(this)
            adapter.notifyDataSetChanged()
            setResult(Activity.RESULT_OK, data)
            startActivity(Intent(this@NewInstrumentActivity, MainActivity::class.java ))
            finish()
        }
    }
}