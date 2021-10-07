package au.edu.swin.sdmd.w09_calcuations_storage

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Class variables in order to access inputs outside onCreate()
    lateinit var number1: EditText
    lateinit var number2: EditText

    override fun onCreate(savedInstancedState: Bundle?){
        super.onCreate(savedInstancedState)
        setContentView(R.layout.activity_main)

        //Check if sharePrefs are available
        checkSharedPrefs()

        //Get input elements
        number1 = findViewById<EditText>(R.id.number1)
        number2 = findViewById<EditText>(R.id.number2)
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

    //Used to save current values in editText fields
    override fun onPause() {
        super.onPause()

        val pref = this.getSharedPreferences("file1",Context.MODE_PRIVATE) ?: return

        with (pref.edit()){
            val number1 = findViewById<EditText>(R.id.number1)
            val number2 = findViewById<EditText>(R.id.number2)

            putString("num1", number1.text.toString())
            putString("num2", number2.text.toString())
            apply()

        }
    }

    //Get values from sharedPreferences
    private fun checkSharedPrefs(){
        val sharedPref = this.getSharedPreferences(getString(R.string.saved_numbers),
        Context.MODE_PRIVATE)
        sharedPref?.let{
            number1.setText(sharedPref.getString(getString(R.string.number1),""))
            number2.setText(sharedPref.getString(getString(R.string.number2),""))
        }

    }
    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()

    //multiple two numbers together
    private fun multiply(number1: String, number2: String) = number1.toInt() * number2.toInt()
}