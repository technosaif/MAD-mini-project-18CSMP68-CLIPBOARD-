package com.example.clipboard1

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<EditText>(R.id.textView2)
        val ed1 = findViewById<EditText>(R.id.mytext)
        val b1 = findViewById<Button>(R.id.button)
        val b2 = findViewById<Button>(R.id.button2)
        val b3 = findViewById<ToggleButton>(R.id.Bold)
        val b4 = findViewById<ToggleButton>(R.id.under)


        b1.setOnClickListener {
            val contextView = findViewById<View>(R.id.button)
            val snack = Snackbar.make(contextView, "Text Pasted", Snackbar.LENGTH_SHORT)
            snack.show()

            tv.setText(ed1.text.toString())
    }
        b2.setOnClickListener{
            val contextView = findViewById<View>(R.id.button2)
            val snack = Snackbar.make(contextView, "Text Copied", Snackbar.LENGTH_SHORT)
            snack.show()
        }
        b3.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
            tv.setTypeface(ed1.typeface, Typeface.BOLD);
                }
            else{
                tv.setTypeface(ed1.typeface, Typeface.NORMAL);


            }
        }
        b4.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                tv.setPaintFlags(ed1.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
            }
            else{
                tv.setPaintFlags(ed1.paintFlags or Paint.ANTI_ALIAS_FLAG);


            }
        }
        val sp1 = findViewById<Spinner>(R.id.spinner)
        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val pos = sp1.selectedItemPosition
                when (pos) {
                    1 -> tv.setTextColor(Color.RED)
                    2 -> tv.setTextColor(Color.BLACK)
                    3 -> tv.setTextColor(Color.GREEN)
                    4 -> tv.setTextColor(Color.BLUE)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val sp2 = findViewById<Spinner>(R.id.spinner2)
        sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var pos = sp2.selectedItemPosition
                when (pos) {
                    1 -> tv.setTextSize(20f)
                    2 -> tv.setTextSize(25f)
                    3 -> tv.setTextSize(30f)
                    4 -> tv.setTextSize(35f)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

//        val sp3 = findViewById<Spinner>(R.id.spinner3)
//        sp3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                val pos = sp3.selectedItemPosition
//                when (pos) {
//                    1 -> tv.typeface = ResourcesCompat.getFont(this,R.font.lacto)
//                    2 -> tv.typeface = ResourcesCompat.getFont(this,R.font.lacktoblack)
//                    3 -> tv.typeface = ResourcesCompat.getFont(this,R.font.lacktoital)
//                    4 -> tv.typeface = ResourcesCompat.getFont(this,R.font.lactooo)
//                }
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//        }

        }
    }