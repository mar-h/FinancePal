package de.hska.financepal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewInstrumentActivity : AppCompatActivity() {

    private lateinit var editInstrumentView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_instrument)
        editInstrumentView = findViewById(R.id.edit_bond)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editInstrumentView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val instrument = editInstrumentView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, instrument)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.instrumentlistsql.REPLY"
    }
}