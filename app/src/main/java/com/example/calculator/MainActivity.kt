package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import com.ezylang.evalex.Expression
import com.udojava.evalex.Expression



class MainActivity : AppCompatActivity() {


    lateinit var resultTv: TextView;
    lateinit var btn1:Button;
    lateinit var btn2:Button;
    lateinit var btn3:Button;
    lateinit var btn4:Button;
    lateinit var btn5:Button;
    lateinit var btn6:Button;
    lateinit var btn7:Button;
    lateinit var btn8:Button;
    lateinit var btn9:Button;
    lateinit var btn0:Button;
    lateinit var point:Button;
    lateinit var clear:Button;

    lateinit var equal:Button;
    lateinit var buttonMultyply:Button;
    lateinit var add:Button;
    lateinit var subtraction:Button;
    lateinit var deviation:Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        resultTv =findViewById(R.id.resultTv)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)
        btn0 = findViewById(R.id.button0)
        point = findViewById(R.id.buttonPoint)

        equal = findViewById(R.id.buttonEqual)

        add = findViewById(R.id.buttonAdd)
        subtraction = findViewById(R.id.buttonSubtraction)
        deviation = findViewById(R.id.buttonDevid)
        buttonMultyply = findViewById(R.id.buttonMultyply)
        clear = findViewById(R.id.clear)

        btn1.setOnClickListener{ appendToExpression("1") }
        btn2.setOnClickListener{ appendToExpression("2") }
        btn3.setOnClickListener{ appendToExpression("3") }
        btn4.setOnClickListener{ appendToExpression("4") }
        btn5.setOnClickListener{ appendToExpression("5") }
        btn6.setOnClickListener{ appendToExpression("6") }
        btn7.setOnClickListener{ appendToExpression("7") }
        btn8.setOnClickListener{ appendToExpression("8") }
        btn9.setOnClickListener{ appendToExpression("9") }
        btn0.setOnClickListener{ appendToExpression("0") }
        point.setOnClickListener{ appendToExpression(".") }

        add.setOnClickListener { appendToExpression("+") }
        subtraction.setOnClickListener { appendToExpression("-") }
        deviation.setOnClickListener { appendToExpression("/") }
        buttonMultyply.setOnClickListener { appendToExpression("*") }

        clear.setOnClickListener{ clear() }

        equal.setOnClickListener{evaluateExpression()}

    }


    private fun appendToExpression(str: String) {
    resultTv.append(str)

    }
    private fun clear(){
        resultTv.text = ""
    }
    private fun evaluateExpression() {

        println(resultTv.text.toString())
        val expression = Expression(resultTv.text.toString())


        try {
            val result = expression.eval()
            resultTv.text = result.toString()
        } catch (ex: ArithmeticException) {
            resultTv.text = "Error"
        }
    }
}