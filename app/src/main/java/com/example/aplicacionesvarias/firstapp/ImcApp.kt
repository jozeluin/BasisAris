package com.example.aplicacionesvarias.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.aplicacionesvarias.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat


//Imc App
class ImcApp : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 50
    private var currentHeight: Int = 120


    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubstracrWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstracrAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESU"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        initComponents()
        initListener()
        initUi()
    }


    private fun initComponents() {
        viewMale = findViewById(R.id.ViewMale)
        viewFemale = findViewById(R.id.ViewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubstracrWeight = findViewById(R.id.btnSubstracrWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstracrAge = findViewById(R.id.btnSubstracrAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAage)
        btnCalculate = findViewById(R.id.btnCalculate)


    }

    private fun initListener() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()


        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->

            val df = DecimalFormat("#.#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubstracrWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubstracrAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
           val result= calculateImc()
            navigateToResult(result)
        }


    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this,ResultaImcActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)
    }

    private fun calculateImc():Double {
        val df=DecimalFormat("#.##")

        val imc = currentWeight / (currentHeight.toDouble() / 100
                * currentHeight.toDouble() / 100)
       return df.format(imc).toDouble()

    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    /**
     * Seleccion de boton, un genero u otro y cuando
     * se selecciona se deselecciona el otro
     */
    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component

        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUi() {
        setWeight()
        setGenderColor()
        setAge()
    }

}