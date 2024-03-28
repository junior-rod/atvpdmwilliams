package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }
        Log.d("PDM24", "No onCreate, $percentual")

        val gas:EditText = findViewById(R.id.gas)
        val alcool:EditText = findViewById(R.id.alcool)
        val swPercentual:Switch = findViewById(R.id.swPercentual)
        val btCalcular:Button = findViewById(R.id.btCalcular)
        val resultado:TextView= findViewById(R.id.textMsg)

        btCalcular.setOnClickListener {
            calcularMelhorPreco(gas.text.toString(), alcool.text.toString(), swPercentual.isChecked, resultado)
        }

    }
    fun calcularMelhorPreco(gasolina: String, alcool: String, percentual75: Boolean, resultado: TextView) {
        val precoGasolina = gasolina.toDoubleOrNull()
        val precoAlcool = alcool.toDoubleOrNull()

        if (precoGasolina != null && precoAlcool != null) {
            val percentual = if (percentual75) 0.75 else 0.7
            val resultadoCalculo = precoAlcool / precoGasolina

            resultado.text = if (resultadoCalculo >= percentual) {
                "Melhor utilizar Gasolina"
            } else {
                "Melhor utilizar Álcool"
            }
        } else {
            resultado.text = "Por favor, insira valores válidos."
        }
    }

override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState)
    }

}