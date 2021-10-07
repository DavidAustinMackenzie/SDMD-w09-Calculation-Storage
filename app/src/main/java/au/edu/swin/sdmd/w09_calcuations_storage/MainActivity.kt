package au.edu.swin.sdmd.w09_calcuations_storage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get input elements
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val equals = findViewById<Button>(R.id.equals)
        val radioAdd = findViewById<RadioButton>(R.id.radioAdd)

        //Get output elements
        val answer = findViewById<TextView> (R.id.answer)

        //Check to see if Add or multiply is selected
        equals.setOnClickListener {
            var result = if(radioAdd.isChecked)
            {
                add(number1.text.toString(), number2.text.toString())
            }
            else
            {
                multiply(number1.text.toString(), number2.text.toString())
            }

            // Show result on the screen
            answer.text = result.toString()
        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()

    //multiple two numbers together
    private fun multiply(number1: String, number2: String) = number1.toInt() * number2.toInt()
}