package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun clickButton (v: View){
        when(v.id){
            R.id.btn_delete -> delete()
            R.id.equal -> resolve()
            else -> append(v.id)
        }
    }
    
    fun delete(){
        match_operation.text = " "
        result_text.text = " "
    }
    fun append(str: Int){
        var textView  = findViewById<TextView>(str)
        match_operation.append(textView.text.toString())
    }
    fun resolve(){
        val ex = ExpressionBuilder(match_operation.text.toString()).build()
        val result = ex.evaluate()
        result_text.text = result.toString()
    }
}