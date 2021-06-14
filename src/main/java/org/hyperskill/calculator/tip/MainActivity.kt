package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.text_view)
        val editText: EditText = findViewById(R.id.edit_text)
        val slider: Slider = findViewById(R.id.slider)

        findViewById<EditText>(R.id.edit_text).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(editText.text.isNotEmpty()) {
                    val tipText = editText.text.toString()
                    val tipPercentage = slider.value

                    val tipEquation = (tipText.toDouble() * tipPercentage.toDouble()) / 100
                    val calculatedTip = BigDecimal(tipEquation).setScale(2, RoundingMode.DOWN)

                    textView.text = "Tip amount: $calculatedTip"
                }
                else
                    textView.text = ""
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        slider.addOnChangeListener { slider, _, _ ->
            if(editText.text.isNotEmpty()) {
                val tipText = editText.text.toString()
                val tipPercentage = slider.value

                val tipEquation = (tipText.toDouble() * tipPercentage.toDouble()) / 100
                val calculatedTip = BigDecimal(tipEquation).setScale(2, RoundingMode.DOWN)

                textView.text = "Tip amount: $calculatedTip"
            }
            else
                textView.text = ""
        }

    }



}