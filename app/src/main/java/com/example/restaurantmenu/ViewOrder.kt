package com.example.restaurantmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantmenu.databinding.ActivityViewOrderBinding

class ViewOrder : AppCompatActivity() {
    private lateinit var binding: ActivityViewOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent

        val notebookQuantity = i.getStringExtra("notebook_quantity").toString().toInt()
        val mouseQuantity = i.getStringExtra("mouse_quantity").toString().toInt()
        val keyboardQuantity = i.getStringExtra("keyboard_quantity").toString().toInt()
        val notebookPrice = i.getDoubleExtra("notebook_price", 0.0)
        val mousePrice = i.getDoubleExtra("mouse_price", 0.0)
        val keyboardPrice = i.getDoubleExtra("keyboard_price", 0.0)

        val notebookTotal = notebookPrice * notebookQuantity;
        val mouseTotal = mousePrice * mouseQuantity;
        val keyboardTotal = keyboardPrice * keyboardQuantity;

        var text = "Resumo do pedido \n\n"
        if (notebookTotal == 0.0 && mouseTotal == 0.0 && keyboardTotal == 0.0) {
            text = "Carrinho Vazio"
        } else {
            if (notebookTotal > 0) {
                text += "Notebook: R$${notebookTotal}\n"
            }
            if (mouseTotal > 0) {
                text += "Mouse: R$${mouseTotal}\n"
            }
            if (keyboardTotal > 0) {
                text += "Keyboard: R$${keyboardTotal}\n"
            }

            text += "\nTotal: ${notebookTotal + mouseTotal + keyboardTotal}"
        }

        binding.viewTotalOrder.text = text

    }
}