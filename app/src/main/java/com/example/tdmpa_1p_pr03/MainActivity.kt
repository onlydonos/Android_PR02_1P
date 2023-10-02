package com.example.tdmpa_1p_pr03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnAgregar = findViewById<Button>(R.id.btnAgregar)
        var btnSumatoria = findViewById<Button>(R.id.btnSumatoria)
        var btnMedia = findViewById<Button>(R.id.btnMedia)
        var btnMediana = findViewById<Button>(R.id.btnMediana)
        var btnBorrar = findViewById<Button>(R.id.btnReiniciar)
        var txtImprimir = findViewById<TextView>(R.id.txtImpresion)
        var txtResult = findViewById<TextView>(R.id.txtResultado)

        btnMediana.setOnClickListener {
            var lista = numeros
            numeros.sort()
            txtImprimir.text = imprimirNumeros()
            val mediana = if (numeros.size % 2 == 1){
                lista[lista.size/2].toDouble()
            } else {
                val medio = lista.size / 2
                (lista[medio - 1] + lista[medio]) / 2.0
            }

            txtResult.text = mediana.toString()
        }

        btnMedia.setOnClickListener {
            var resultadoMedia = numeros.average()
            txtResult.text = resultadoMedia.toString()
        }

        btnSumatoria.setOnClickListener {
            var resultado = numeros.sum()
            txtResult.text = resultado.toString()
        }

        btnAgregar.setOnClickListener{
            agregarNumeros()
            txtImprimir.text = imprimirNumeros()
        }

        btnBorrar.setOnClickListener {
            txtImprimir.text = ""
        }
    }
    var numeros : MutableList<Double> = mutableListOf()

    fun agregarNumeros(){
        var txtCantidades = findViewById<EditText>(R.id.txtNumeros)
        numeros.add(txtCantidades.text.toString().toDouble())

    }

    fun imprimirNumeros() : String {
        var cadena = ""
        for (i in 0 .. numeros.size-1){
            cadena = cadena+("${numeros[i]} \n")
        }
        return cadena
    }
}