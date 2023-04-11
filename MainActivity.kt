
package com.example.sd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val n1 : EditText = findViewById(R.id.nam)
        val n2 : EditText = findViewById(R.id.cg)
        val b1 : Button =findViewById(R.id.b1)
        val b2 : Button =findViewById(R.id.b2)
        b1.setOnClickListener{
            val name=n1.text.toString()
            val cgpa=n2.text.toString()

            val file = File(getExternalFilesDir(null),"student.txt")
             val fos = FileOutputStream(file, false)
            fos.write("$name,$cgpa".toByteArray())
            fos.close()
            n1.setText("")
            n2.setText("")
            Toast.makeText(this@MainActivity,"info added", Toast.LENGTH_LONG).show()
        }
        b2.setOnClickListener {
            val file = File(getExternalFilesDir(null),"student.txt")
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            var line :String
            line = br.readLine()
            var parts = line.split(",")
            n1.setText(parts[0])
            n2.setText(parts[1])
            Toast.makeText(this@MainActivity,"info loaded", Toast.LENGTH_LONG).show()
        }
    }
}
