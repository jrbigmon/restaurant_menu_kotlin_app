package com.example.restaurantmenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val notebookPrice = 1000.00
    private val mousePrice = 150.00
    private val keyboardPrice = 350.99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkNotebook.setOnClickListener({
            if (binding.checkNotebook.isChecked()) {
                var quantity = binding.editQuantityNotebook.text.toString().toInt()

                if (quantity < 1) {
                    quantity = 1
                    binding.editQuantityNotebook.setText("$quantity")
                }

                val price = quantity * notebookPrice
                binding.notebookPrice.setText("R$${price}")
                binding.notebookPrice.visibility = View.VISIBLE
            } else {
                binding.editQuantityNotebook.setText("0")
                binding.notebookPrice.visibility = View.GONE
            }
        })

        binding.checkMouse.setOnClickListener({
            if (binding.checkMouse.isChecked()) {
                var quantity = binding.editQuantityMouse.text.toString().toInt()

                if (quantity < 1) {
                    quantity = 1
                    binding.editQuantityMouse.setText("$quantity")
                }

                val price = quantity * mousePrice
                binding.mousePrice.setText("R$${price}")
                binding.mousePrice.visibility = View.VISIBLE
            } else {
                binding.editQuantityMouse.setText("0")
                binding.mousePrice.visibility = View.GONE
            }
        })

        binding.checkKeyboard.setOnClickListener({
            if (binding.checkKeyboard.isChecked()) {
                var quantity = binding.editQuantityKeyboard.text.toString().toInt()

                if (quantity < 1) {
                    quantity = 1
                    binding.editQuantityKeyboard.setText("$quantity")
                }

                val price = quantity * keyboardPrice
                binding.keyboardPrice.setText("R$${price}")
                binding.keyboardPrice.visibility = View.VISIBLE
            } else {
                binding.editQuantityNotebook.setText("0")
                binding.keyboardPrice.visibility = View.GONE
            }
        })

        binding.buttonMakeAOrder.setOnClickListener({
            val i = Intent(this, SplashScreen::class.java)
            i.putExtra("notebook_quantity", binding.editQuantityNotebook.text.toString())
            i.putExtra("mouse_quantity", binding.editQuantityMouse.text.toString())
            i.putExtra("keyboard_quantity", binding.editQuantityKeyboard.text.toString())
            i.putExtra("notebook_price", notebookPrice)
            i.putExtra("mouse_price", mousePrice)
            i.putExtra("keyboard_price", keyboardPrice)
            startActivity(i)
        })
    }
}